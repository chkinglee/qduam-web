package com.qduam.modules.mail.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.mail.entity.Mail;
import com.qduam.modules.mail.service.MailService;
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
@RequestMapping(value = "mail")
public class MailController extends BaseController {
    
    @Autowired
    private MailService mailService;

    /**
     * 查询站内信列表
     * @param model
     * @param mail
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Mail mail) {
        List<Mail> mailList = mailService.findList(mail);
        model.addAttribute("mailList", mailList);
        return "mail/list";
    }

    /**
     * 查询站内信详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Mail mail = mailService.get(id);
        model.addAttribute("mail", mail);
        return "mail/view";
    }

    /**
     * 删除站内信
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = mailService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/mail/list";
    }

    /**
     * 编辑站内信（添加或修改）
     * @param model
     * @param mail
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Mail mail) {
        if (id != null) {
            mail = mailService.get(id);
        }
        model.addAttribute("mail", mail);
        return "mail/edit";
    }

    /**
     * 保存站内信（添加或修改）
     * @param mail
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Mail mail, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (mail.getId() == null) {
            successNum = mailService.insert(mail);
        } else {
            successNum = mailService.update(mail);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/mail/list";
    }

}
