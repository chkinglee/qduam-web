package com.qduam.modules.sys.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.sys.entity.Problem;
import com.qduam.modules.sys.service.ProblemService;
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
@RequestMapping(value = "problem")
public class ProblemController extends BaseController {
    
    @Autowired
    private ProblemService problemService;

    /**
     * 查询问题反馈列表
     * @param model
     * @param problem
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Problem problem) {
        List<Problem> problemList = problemService.findList(problem);
        model.addAttribute("problemList", problemList);
        return "problem/list";
    }

    /**
     * 查询问题反馈详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Problem problem = problemService.get(id);
        model.addAttribute("problem", problem);
        return "problem/view";
    }

    /**
     * 删除问题反馈
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = problemService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/problem/list";
    }

    /**
     * 编辑问题反馈（添加或修改）
     * @param model
     * @param problem
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Problem problem) {
        if (id != null) {
            problem = problemService.get(id);
        }
        model.addAttribute("problem", problem);
        return "problem/edit";
    }

    /**
     * 保存问题反馈（添加或修改）
     * @param problem
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Problem problem, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (problem.getId() == null) {
            successNum = problemService.insert(problem);
        } else {
            successNum = problemService.update(problem);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/problem/list";
    }

}
