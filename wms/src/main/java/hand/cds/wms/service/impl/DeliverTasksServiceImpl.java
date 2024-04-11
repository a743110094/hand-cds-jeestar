package hand.cds.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hand.cds.wms.domain.DeliverTasks;
import hand.cds.wms.domain.DeliverTasksVO;
import hand.cds.wms.mapper.DeliverTasksMapper;
import hand.cds.wms.service.DeliverTasksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.h4n.base.util.ChineseUtil;
import site.h4n.base.util.UnitUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author 49944
 * @description 针对表【deliver_tasks(拣货任务)】的数据库操作Service实现
 * @createDate 2024-04-09 22:24:05
 */
@Service
@Slf4j
public class DeliverTasksServiceImpl extends ServiceImpl<DeliverTasksMapper, DeliverTasks>
        implements DeliverTasksService {

    private static final Random rd = new Random();
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    /**
     * 创建拣货任务
     *
     * @param deliverTasksVO 交付任务 vo
     */
    @Override
    public void createDeliveryTask(DeliverTasksVO deliverTasksVO) {
        /// -------- 更新历史数据
        updateHistory();
        final ArrayList<DeliverTasks> objects = new ArrayList<>();
        for (int i = 0; i < rd.nextInt(4) + 1; i++) {
            final DeliverTasks deliverTasks = new DeliverTasks();
            BeanUtils.copyProperties(deliverTasksVO, deliverTasks);
            deliverTasks.setSubInventory(String.format("S%s_Q%s", rd.nextInt(400) + 33, rd.nextInt(400) + 14));
            deliverTasks.setWarehouse(String.format("W%s", rd.nextInt(500) + 23));
            deliverTasks.setLot(String.format("L%s", rd.nextInt(100) + 10));
            deliverTasks.setUnit(UnitUtil.UNITS.get((int) (System.currentTimeMillis() % UnitUtil.UNITS.size())));
            deliverTasks.setStatus("初始化");
            deliverTasks.setType("出库");
            deliverTasks.setName("拣货任务A" + (rd.nextInt(10000000) + 10000000));
            deliverTasks.setNo("STOCK" + System.currentTimeMillis() + (rd.nextInt(99) + 10));
            deliverTasks.setOperator(ChineseUtil.randomChineseName());
            deliverTasks.setQty((rd.nextInt(800) + 10));
            deliverTasks.setItemCode("T" + (rd.nextInt(9) + 1) + (rd.nextInt(900000) + 100000));
            objects.add(deliverTasks);
        }
        saveBatch(objects);
    }

    @Override
    public List<DeliverTasks> getByPage(Integer page) {
        /// -------- 更新历史数据
        updateHistory();
        final LambdaQueryWrapper<DeliverTasks> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(DeliverTasks::getId);
        return this.page(Page.of(page, 10), wrapper).getRecords();
    }

    private void updateHistory() {
        executorService.submit(() -> {
            try {
                baseMapper.updateDelivering();
                baseMapper.updateFinished();
            } catch (Exception e) {
                log.error("更新历史数据失败", e);
            }
        });
    }
}




