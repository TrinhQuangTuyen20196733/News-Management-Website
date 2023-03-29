package vn.com.standford.springmvcbasic1.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.com.standford.springmvcbasic1.dto.NewDTO;
import vn.com.standford.springmvcbasic1.service.ICategoryService;
import vn.com.standford.springmvcbasic1.service.INewService;
import vn.com.standford.springmvcbasic1.util.Messageutil;

import java.util.Map;


@Controller(value = "newControllerOfAdmin")
public class NewController {

    @Autowired
    private INewService newService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private Messageutil messageutil;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam(value = "message", required = false) String message) {
        NewDTO model = new NewDTO();
        ModelAndView mav = new ModelAndView("admin/new/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setPage(page);
        model.setListResult(newService.findAll(pageable));
        model.setTotalItem(newService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        mav.addObject("model", model);
        Map<String,String> messageMap= messageutil.getMessage(message);
        mav.addObject("message",messageMap.get("message"));
        mav.addObject("alert",messageMap.get("alert"));
        return mav;
    }

    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "message", required = false) String message) {
        ModelAndView mav = new ModelAndView("admin/new/edit");
        NewDTO model = new NewDTO();
        if (id != null) {
            model = newService.findById(id);
        }
        Map<String,String> messageMap= messageutil.getMessage(message);
        mav.addObject("message",messageMap.get("message"));
        mav.addObject("alert",messageMap.get("alert"));
        mav.addObject("model", model);
        mav.addObject("categories", categoryService.findAll());
        return mav;
    }
}