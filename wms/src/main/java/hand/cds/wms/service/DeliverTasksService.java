package hand.cds.wms.service;

import hand.cds.wms.domain.DeliverTasks;
import com.baomidou.mybatisplus.extension.service.IService;
import hand.cds.wms.domain.DeliverTasksVO;

import java.util.List;

/**
* @author 49944
* @description 针对表【deliver_tasks(拣货任务)】的数据库操作Service
* @createDate 2024-04-09 22:24:05
*/
public interface DeliverTasksService extends IService<DeliverTasks> {

    /**
     * 创建拣货任务
     *
     * @param deliverTasksVO 交付任务 vo
     */
    void createDeliveryTask(DeliverTasksVO deliverTasksVO);

    /**
     * 按页面获取
     *
     * @param page 页
     * @return {@link List}<{@link DeliverTasks}>
     */
    List<DeliverTasks> getByPage(Integer page);
}
