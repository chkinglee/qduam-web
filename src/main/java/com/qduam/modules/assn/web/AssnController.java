package com.qduam.modules.assn.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.assn.entity.Assn;
import com.qduam.modules.assn.service.AssnService;
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
@RequestMapping(value = "assn")
public class AssnController extends BaseController {

    @Autowired
    private AssnService assnService;

    /**
     * 查询社团列表
     * @param model
     * @param assn
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Assn assn) {
        List<Assn> assnList = assnService.findList(assn);
        model.addAttribute("assnList", assnList);
        return "assn/list";
    }

    /**
     * 查询社团详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Assn assn = assnService.get(id);
        model.addAttribute("assn", assn);
        return "assn/view";
    }

    /**
     * 删除社团
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = assnService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/assn/list";
    }

    /**
     * 编辑社团（添加或修改）
     * @param model
     * @param assn
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Assn assn) {
        if (id != null) {
            assn = assnService.get(id);
        }
        model.addAttribute("assn", assn);
        return "assn/edit";
    }

    /**
     * 保存社团（添加或修改）
     * @param assn
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Assn assn, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (assn.getId() == null) {
            successNum = assnService.insert(assn);
        } else {
            successNum = assnService.update(assn);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/assn/list";
    }
}
