package hand.cds.qms.controller;

import hand.cds.qms.domain.InspectionTasks;
import hand.cds.qms.service.InspectionTasksService;
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
@RequestMapping("inspectionTask")
public class TestController {

    @Resource
    InspectionTasksService inspectionTasksService;

    @GetMapping
    public ModelAndView indexPage(@RequestParam(required = false,defaultValue = "1",name = "page") Integer page){
        ModelAndView modelAndView  = new ModelAndView("inspection.btl");
        final List<InspectionTasks> byPage = inspectionTasksService.getByPage(page);
        modelAndView.addObject("list", byPage);
        modelAndView.addObject("page",page);
        return modelAndView;
    }




}
