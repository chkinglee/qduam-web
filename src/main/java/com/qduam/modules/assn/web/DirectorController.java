package com.qduam.modules.assn.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.assn.entity.Director;
import com.qduam.modules.assn.service.DirectorService;
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
@RequestMapping(value = "director")
public class DirectorController extends BaseController {
    
    @Autowired
    private DirectorService directorService;

    /**
     * 查询部长列表
     * @param model
     * @param director
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Director director) {
        List<Director> directorList = directorService.findList(director);
        model.addAttribute("directorList", directorList);
        return "director/list";
    }

    /**
     * 查询部长详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Director director = directorService.get(id);
        model.addAttribute("director", director);
        return "director/view";
    }

    /**
     * 删除部长
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = directorService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/director/list";
    }

    /**
     * 编辑部长（添加或修改）
     * @param model
     * @param director
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Director director) {
        if (id != null) {
            director = directorService.get(id);
        }
        model.addAttribute("director", director);
        return "director/edit";
    }

    /**
     * 保存部长（添加或修改）
     * @param director
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Director director, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (director.getId() == null) {
            successNum = directorService.insert(director);
        } else {
            successNum = directorService.update(director);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/director/list";
    }

}
