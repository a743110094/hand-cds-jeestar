package hand.cds.wms.controller;

import hand.cds.wms.domain.DeliverTasks;
import hand.cds.wms.service.DeliverTasksService;
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
@RequestMapping("deliveryTask")
public class TestController {

    @Resource
    DeliverTasksService deliverTasksService;

    /**
     * 分页获取拣货任务
     *
     * @param page 页
     * @return {@link ModelAndView}
     */
    @GetMapping
    public ModelAndView indexPage(@RequestParam(required = false,defaultValue = "1",name = "page") Integer page){
        ModelAndView modelAndView  = new ModelAndView("hello.btl");
        final List<DeliverTasks> byPage = deliverTasksService.getByPage(page);
        modelAndView.addObject("list", byPage);
        modelAndView.addObject("page",page);
        return modelAndView;
    }




}
