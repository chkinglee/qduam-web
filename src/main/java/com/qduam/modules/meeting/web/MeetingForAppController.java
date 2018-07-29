package com.qduam.modules.meeting.web;

import com.qduam.common.json.AjaxJson;
import com.qduam.common.persistence.BaseForAppController;
import com.qduam.common.utils.DictUtils;
import com.qduam.modules.meeting.entity.Meeting;
import com.qduam.modules.meeting.service.MeetingService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/app/meeting")
public class MeetingForAppController extends BaseForAppController {
    
    @Resource
    private MeetingService meetingService;

    @RequestMapping(value = "/list")
    public String findListMeeting(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Meeting entity= (Meeting) JSONObject.toBean(jsonOb, Meeting.class);
            List<Meeting> list= meetingService.findList(entity);
            j.put("list", list);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/save")
    public synchronized String saveMeeting(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Meeting Meeting = (Meeting) JSONObject.toBean(jsonOb, Meeting.class);

            if(Meeting.getId() == null) {
                if(meetingService.insert(Meeting)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            } else {
                if(meetingService.update(Meeting)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            }
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/del")
    public synchronized String delMeeting(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Meeting Meeting = (Meeting) JSONObject.toBean(jsonOb, Meeting.class);
            if(meetingService.delete(Meeting.getId())>0){
                j.put("result", "success");
            } else {
                j.put("result", "fail");
            }
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

}
