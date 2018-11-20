package com.qduam.modules.meeting.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.meeting.entity.Meeting;
import com.qduam.modules.meeting.service.MeetingService;
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
@RequestMapping(value = "meeting")
public class MeetingController extends BaseController {
    
    @Autowired
    private MeetingService meetingService;

    /**
     * 查询会议列表
     * @param model
     * @param meeting
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Meeting meeting) {
        List<Meeting> meetingList = meetingService.findList(meeting);
        model.addAttribute("meetingList", meetingList);
        return "meeting/list";
    }

    /**
     * 查询会议详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Meeting meeting = meetingService.get(id);
        model.addAttribute("meeting", meeting);
        return "meeting/view";
    }

    /**
     * 删除会议
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = meetingService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/meeting/list";
    }

    /**
     * 编辑会议（添加或修改）
     * @param model
     * @param meeting
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Meeting meeting) {
        if (id != null) {
            meeting = meetingService.get(id);
        }
        model.addAttribute("meeting", meeting);
        return "meeting/edit";
    }

    /**
     * 保存会议（添加或修改）
     * @param meeting
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Meeting meeting, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (meeting.getId() == null) {
            successNum = meetingService.insert(meeting);
        } else {
            successNum = meetingService.update(meeting);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/meeting/list";
    }

}
