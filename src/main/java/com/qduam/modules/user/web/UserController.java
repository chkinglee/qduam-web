package com.qduam.modules.user.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.user.entity.User;
import com.qduam.modules.user.service.UserService;
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
@RequestMapping(value = "user")
public class UserController extends BaseController {
    
    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, User user) {
        List<User> userList = userService.findList(user);
        model.addAttribute("userList", userList);
        return "user/list";
    }

    /**
     * 查询用户详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "user/view";
    }

    /**
     * 删除用户
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = userService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/user/list";
    }

    /**
     * 编辑用户（添加或修改）
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, User user) {
        if (id != null) {
            user = userService.get(id);
        }
        model.addAttribute("user", user);
        return "user/edit";
    }

    /**
     * 保存用户（添加或修改）
     * @param user
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(User user, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (user.getId() == null) {
            successNum = userService.insert(user);
        } else {
            successNum = userService.update(user);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/user/list";
    }

}
