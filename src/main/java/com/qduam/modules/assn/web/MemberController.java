package com.qduam.modules.assn.web;

import com.qduam.modules.assn.entity.Member;
import com.qduam.modules.assn.service.MemberService;
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
@RequestMapping(value = "member")
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    /**
     * 查询部员列表
     * @param model
     * @param member
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Member member) {
        List<Member> memberList = memberService.findList(member);
        model.addAttribute("memberList", memberList);
        return "member/list";
    }

    /**
     * 查询部员详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Member member = memberService.get(id);
        model.addAttribute("member", member);
        return "member/view";
    }

    /**
     * 删除部员
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = memberService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/member/list";
    }

    /**
     * 编辑部员（添加或修改）
     * @param model
     * @param member
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Member member) {
        if (id != null) {
            member = memberService.get(id);
        }
        model.addAttribute("member", member);
        return "member/edit";
    }

    /**
     * 保存部员（添加或修改）
     * @param member
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Member member, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (member.getId() == null) {
            successNum = memberService.insert(member);
        } else {
            successNum = memberService.update(member);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/member/list";
    }

}
