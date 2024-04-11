package hand.cds.wms.controller;

import hand.cds.wms.domain.DeliverTasksVO;
import hand.cds.wms.service.DeliverTasksService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.h4n.base.entity.Result;

@RestController
@RequestMapping("deliveryTask")
public class RestControllers {
    @Resource
    DeliverTasksService deliverTasksService;

    /**
     * 根据订单创建拣货任务
     *
     * @param deliverTasksVO 交付任务 vo
     * @return {@link Result}
     */
    @PostMapping("create")
    public Result createDeliveryTask(@RequestBody DeliverTasksVO deliverTasksVO){
        deliverTasksService.createDeliveryTask(deliverTasksVO);
        return Result.success();
    }
}
