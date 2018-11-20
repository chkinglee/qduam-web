package com.qduam.modules.sys.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.sys.entity.Guide;
import com.qduam.modules.sys.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2018/11/20
 **/
@Controller
@RequestMapping(value = "guide")
public class GuideController extends BaseController {
    
    @Autowired
    private GuideService guideService;

    /**
     * 查询服务指南列表
     * @param model
     * @param guide
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Guide guide) {
        List<Guide> guideList = guideService.findList(guide);
        model.addAttribute("guideList", guideList);
        return "guide/list";
    }

    /**
     * 查询服务指南详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Guide guide = guideService.get(id);
        model.addAttribute("guide", guide);
        return "guide/view";
    }

    /**
     * 删除服务指南
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = guideService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/guide/list";
    }

    /**
     * 编辑服务指南（添加或修改）
     * @param model
     * @param guide
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Guide guide) {
        if (id != null) {
            guide = guideService.get(id);
        }
        model.addAttribute("guide", guide);
        return "guide/edit";
    }

    /**
     * 保存服务指南（添加或修改）
     * @param guide
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Guide guide, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (guide.getId() == null) {
            successNum = guideService.insert(guide);
        } else {
            successNum = guideService.update(guide);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/guide/list";
    }

}
