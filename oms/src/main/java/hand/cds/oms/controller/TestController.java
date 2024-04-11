package hand.cds.oms.controller;

import hand.cds.oms.domain.Order;
import hand.cds.oms.domain.OrderVO;
import hand.cds.oms.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import site.h4n.base.entity.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试控制器
 *
 * @author Heaven96
 * @date 2024/04/08
 */
@Controller
@RequestMapping("order")
public class TestController {

    @Resource
    OrderService orderService;

    @GetMapping
    public ModelAndView indexPage(@RequestParam(required = false,defaultValue = "1",name = "page") Integer page){
        ModelAndView modelAndView  = new ModelAndView("hello.btl");
        final List<Order> byPage = orderService.getByPage(page);
        modelAndView.addObject("list", byPage);
        modelAndView.addObject("page",page);
        return modelAndView;
    }




}
