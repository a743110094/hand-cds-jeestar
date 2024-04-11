package hand.cds.mall.controller;

import hand.cds.mall.service.MallOrderService;
import hand.cds.mall.domain.MallOrderVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.h4n.base.entity.Result;

@RestController
@RequestMapping("mallOrder")
public class RestControllers {
    @Resource
    MallOrderService mallOrderService;

    @PostMapping("create")
    public Result create(@RequestBody MallOrderVO mallOrderVO){
        mallOrderService.create(mallOrderVO);
        return Result.success();
    }
}
