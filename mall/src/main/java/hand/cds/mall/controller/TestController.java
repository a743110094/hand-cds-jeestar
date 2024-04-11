package hand.cds.mall.controller;

import hand.cds.mall.service.MallOrderService;
import hand.cds.mall.domain.MallOrder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 测试控制器
 *
 * @author Heaven96
 * @date 2024/04/08
 */
@Controller
@RequestMapping("mallOrder")
public class TestController {

    @Resource
    MallOrderService mallOrderService;

    @GetMapping
    public ModelAndView indexPage(@RequestParam(required = false,defaultValue = "1",name = "page") Integer page){
        ModelAndView modelAndView  = new ModelAndView("mallOrder.html");
        final List<MallOrder> byPage = mallOrderService.getByPage(page);
        modelAndView.addObject("list", byPage);
        modelAndView.addObject("page",page);
        return modelAndView;
    }




}
