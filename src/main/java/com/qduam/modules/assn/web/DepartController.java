package com.qduam.modules.assn.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.assn.service.DepartService;
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
 * @Version: 2018/11/18
 **/
@Controller
@RequestMapping(value = "depart")
public class DepartController extends BaseController {
    
    @Autowired
    private DepartService departService;

    /**
     * 查询文章列表
     * @param model
     * @param depart
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Depart depart) {
        List<Depart> departList = departService.findList(depart);
        model.addAttribute("departList", departList);
        return "depart/list";
    }

    /**
     * 查询文章详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Depart depart = departService.get(id);
        model.addAttribute("depart", depart);
        return "depart/view";
    }

    /**
     * 删除文章
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = departService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/depart/list";
    }

    /**
     * 编辑文章（添加或修改）
     * @param model
     * @param depart
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Depart depart) {
        if (id != null) {
            depart = departService.get(id);
        }
        model.addAttribute("depart", depart);
        return "depart/edit";
    }

    /**
     * 保存文章（添加或修改）
     * @param depart
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Depart depart, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (depart.getId() == null) {
            successNum = departService.insert(depart);
        } else {
            successNum = departService.update(depart);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/depart/list";
    }

}
