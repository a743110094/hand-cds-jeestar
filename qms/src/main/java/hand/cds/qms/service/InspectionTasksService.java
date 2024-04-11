package hand.cds.qms.service;

import hand.cds.qms.domain.InspectionTasks;
import com.baomidou.mybatisplus.extension.service.IService;
import hand.cds.qms.domain.InspectionTasksVO;

import java.util.List;

/**
* @author 49944
* @description 针对表【inspection_tasks(质检任务)】的数据库操作Service
* @createDate 2024-04-09 20:40:03
*/
public interface InspectionTasksService extends IService<InspectionTasks> {

    /**
     * 创建检查任务
     *
     * @param inspectionTasksVO 检验任务 VO
     */
    void createInspectionTasks(InspectionTasksVO inspectionTasksVO);

    /**
     * 按页面获取
     *
     * @param page 页
     * @return {@link List}<{@link InspectionTasks}>
     */
    List<InspectionTasks> getByPage(Integer page);
}
