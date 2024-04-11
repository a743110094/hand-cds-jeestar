package hand.cds.oms.service.impl;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hand.cds.oms.domain.Order;
import hand.cds.oms.domain.OrderVO;
import hand.cds.oms.service.OrderService;
import hand.cds.oms.mapper.OrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @author 49944
* @description 针对表【order】的数据库操作Service实现
* @createDate 2024-04-09 00:02:43
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {

    ExecutorService executorService = Executors.newFixedThreadPool(1);


    @Override
    public List<Order> getByPage(Integer page) {
        updateHistory();
        final LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Order::getId);
        return this.page(Page.of(page,10),wrapper).getRecords();
    }

    @Override
    public void importOrder(OrderVO orderVO) {
        updateHistory();
        final Order order = new Order();
        BeanUtils.copyProperties(orderVO,order);
        order.setFullfillNo("XL"+ System.currentTimeMillis());
        save(order);
    }

    private void updateHistory() {
        executorService.submit(() -> {
            try {
                baseMapper.updatePending();
                baseMapper.updateFinished();
            } catch (Exception e) {
                log.error("更新历史数据失败", e);
            }
        });
    }
}




