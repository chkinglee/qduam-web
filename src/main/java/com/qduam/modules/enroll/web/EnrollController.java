package com.qduam.modules.enroll.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.enroll.entity.Enroll;
import com.qduam.modules.enroll.service.EnrollService;
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
@RequestMapping(value = "enroll")
public class EnrollController extends BaseController {
    
    @Autowired
    private EnrollService enrollService;

    /**
     * 查询报名信息列表
     * @param model
     * @param enroll
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Enroll enroll) {
        List<Enroll> enrollList = enrollService.findList(enroll);
        model.addAttribute("enrollList", enrollList);
        return "enroll/list";
    }

    /**
     * 查询报名信息详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Enroll enroll = enrollService.get(id);
        model.addAttribute("enroll", enroll);
        return "enroll/view";
    }

    /**
     * 删除报名信息
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = enrollService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/enroll/list";
    }

    /**
     * 编辑报名信息（添加或修改）
     * @param model
     * @param enroll
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Enroll enroll) {
        if (id != null) {
            enroll = enrollService.get(id);
        }
        model.addAttribute("enroll", enroll);
        return "enroll/edit";
    }

    /**
     * 保存报名信息（添加或修改）
     * @param enroll
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Enroll enroll, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (enroll.getId() == null) {
            successNum = enrollService.insert(enroll);
        } else {
            successNum = enrollService.update(enroll);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/enroll/list";
    }

}
