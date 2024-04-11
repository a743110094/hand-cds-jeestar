package hand.cds.oms.controller;

import hand.cds.oms.domain.OrderVO;
import hand.cds.oms.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.h4n.base.entity.Result;

@RestController
@RequestMapping("order")
public class RestControllers {
    @Resource
    OrderService orderService;

    @PostMapping("importOrder")
    public Result importOrder(@RequestBody OrderVO orderVO){
        orderService.importOrder(orderVO);
        return Result.success();
    }
}
