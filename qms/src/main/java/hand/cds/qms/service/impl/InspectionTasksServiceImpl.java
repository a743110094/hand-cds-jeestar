package hand.cds.qms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hand.cds.qms.domain.InspectionTasks;
import hand.cds.qms.domain.InspectionTasksVO;
import hand.cds.qms.mapper.InspectionTasksMapper;
import hand.cds.qms.service.InspectionTasksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.h4n.base.util.UnitUtil;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * @author 49944
 * @description 针对表【inspection_tasks(质检任务)】的数据库操作Service实现
 * @createDate 2024-04-09 20:40:03
 */
@Service
@Slf4j
public class InspectionTasksServiceImpl extends ServiceImpl<InspectionTasksMapper, InspectionTasks>
        implements InspectionTasksService {

    private static final Random rd = new Random();
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Override
    public void createInspectionTasks(InspectionTasksVO inspectionTasksVO) {
        /// -------- 更新历史数据
        updateHistory();
        final InspectionTasks inspectionTasks = new InspectionTasks();
        BeanUtils.copyProperties(inspectionTasksVO, inspectionTasks);
        inspectionTasks.setNo("IT" + System.currentTimeMillis());
        inspectionTasks.setName("质检任务" + rd.nextInt(100000, 990000));
        inspectionTasks.setQty(rd.nextInt(10, 80));
        inspectionTasks.setUnit(UnitUtil.UNITS.get((int) (System.currentTimeMillis() % UnitUtil.UNITS.size())));
        this.save(inspectionTasks);
    }

    @Override
    public List<InspectionTasks> getByPage(Integer page) {
        /// -------- 更新历史数据
        updateHistory();
        final LambdaQueryWrapper<InspectionTasks> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(InspectionTasks::getId);
        return this.page(Page.of(page, 20), wrapper).getRecords();
    }

    private void updateHistory() {
        executorService.submit(() -> {
            try {
                baseMapper.updateInspectioning();
                baseMapper.updateFinished();
            } catch (Exception e) {
                log.error("更新历史数据失败", e);
            }
        });
    }
}




