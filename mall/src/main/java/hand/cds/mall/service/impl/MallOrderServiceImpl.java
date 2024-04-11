package hand.cds.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hand.cds.mall.domain.MallOrder;
import hand.cds.mall.domain.MallOrderVO;
import hand.cds.mall.service.MallOrderService;
import hand.cds.mall.mapper.MallOrderMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @author 49944
* @description 针对表【order】的数据库操作Service实现
* @createDate 2024-04-09 00:02:43
*/
@Service
@Slf4j
public class MallOrderServiceImpl extends ServiceImpl<MallOrderMapper, MallOrder>
    implements MallOrderService {

    @Resource
    TransactionTemplate trx;

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    ExecutorService executorService2 = Executors.newFixedThreadPool(2);


    @Override
    public List<MallOrder> getByPage(Integer page) {
        updateHistory();
        final LambdaQueryWrapper<MallOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(MallOrder::getId);
        return this.page(Page.of(page,10),wrapper).getRecords();
    }

    @Override
    public void create(MallOrderVO mallOrderVO) {


        final MallOrder mallOrder = new MallOrder();
        BeanUtils.copyProperties(mallOrderVO, mallOrder);
        mallOrder.setNo("TM"+System.currentTimeMillis());
        save(mallOrder);

        updateHistory();
        //// 推送jeeStar
        trx.setTimeout(10);
        trx.executeWithoutResult((status)->pushOrderToJeeStar(mallOrder));
    }



    private void updateHistory() {
        executorService.submit(() -> {
            try {
                baseMapper.updatePending();
                baseMapper.updateDeliveryTime();
                baseMapper.updateReceiptTime();
                baseMapper.updateFinished();
            } catch (Exception e) {
                log.error("更新历史数据失败", e);
            }
        });
    }

    /**
     * 将订单推送到 JeeStar
     */
    private void pushOrderToJeeStar(MallOrder order) {
        LambdaUpdateWrapper<MallOrder> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(MallOrder::getPushToJeestar,2);
        wrapper.eq(MallOrder::getPushToJeestar,0);
        wrapper.eq(MallOrder::getId,order.getId());
        final int update = baseMapper.update(wrapper);
        /// -------- 1 持锁
        if (update != 1){
            log.info("持锁失败");
        }
        // 1.1 持锁成功

        /// -------- 2 推送
        // 2.1 TODO

        /// -------- 回写状态
        if(true){
            LambdaUpdateWrapper<MallOrder> wrapper1 = new LambdaUpdateWrapper<>();
            wrapper1.set(MallOrder::getPushToJeestar,1);
            wrapper1.eq(MallOrder::getPushToJeestar,2);
            wrapper1.eq(MallOrder::getId,order.getId());
            baseMapper.update(wrapper1);
        }else{
            LambdaUpdateWrapper<MallOrder> wrapper2 = new LambdaUpdateWrapper<>();
            wrapper2.set(MallOrder::getPushToJeestar,0);
            wrapper2.eq(MallOrder::getPushToJeestar,2);
            wrapper2.eq(MallOrder::getId,order.getId());
            baseMapper.update(wrapper2);
        }

    }
}




