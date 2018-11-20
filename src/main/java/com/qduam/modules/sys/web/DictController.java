package com.qduam.modules.sys.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.sys.entity.Dict;
import com.qduam.modules.sys.service.DictService;
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
@RequestMapping(value = "dict")
public class DictController extends BaseController {
    
    @Autowired
    private DictService dictService;

    /**
     * 查询字典列表
     * @param model
     * @param dict
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Dict dict) {
        List<Dict> dictList = dictService.findList(dict);
        model.addAttribute("dictList", dictList);
        return "dict/list";
    }

    /**
     * 查询字典详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Dict dict = dictService.get(id);
        model.addAttribute("dict", dict);
        return "dict/view";
    }

    /**
     * 删除字典
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = dictService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/dict/list";
    }

    /**
     * 编辑字典（添加或修改）
     * @param model
     * @param dict
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Dict dict) {
        if (id != null) {
            dict = dictService.get(id);
        }
        model.addAttribute("dict", dict);
        return "dict/edit";
    }

    /**
     * 保存字典（添加或修改）
     * @param dict
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Dict dict, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (dict.getId() == null) {
            successNum = dictService.insert(dict);
        } else {
            successNum = dictService.update(dict);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/dict/list";
    }

}
