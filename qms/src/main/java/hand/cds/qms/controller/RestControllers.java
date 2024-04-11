package hand.cds.qms.controller;

import hand.cds.qms.domain.InspectionTasksVO;
import hand.cds.qms.service.InspectionTasksService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.h4n.base.entity.Result;

@RestController
@RequestMapping("inspectionTask")
public class RestControllers {
    @Resource
    InspectionTasksService inspectionTasksService;

    /**
     * 创建质检任务
     *
     * @param inspectionTasksVO 检验任务 VO
     * @return {@link Result}
     */
    @PostMapping("create")
    public Result createInspectionTasks(@RequestBody InspectionTasksVO inspectionTasksVO){
        inspectionTasksService.createInspectionTasks(inspectionTasksVO);
        return Result.success();
    }
}
