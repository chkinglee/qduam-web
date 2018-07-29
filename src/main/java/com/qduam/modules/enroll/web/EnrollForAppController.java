package com.qduam.modules.enroll.web;

import com.qduam.common.json.AjaxJson;
import com.qduam.common.persistence.BaseForAppController;
import com.qduam.common.utils.DictUtils;
import com.qduam.modules.enroll.entity.Enroll;
import com.qduam.modules.enroll.service.EnrollService;
import com.qduam.modules.student.dao.StudentDao;
import com.qduam.modules.student.entity.Student;
import com.qduam.modules.student.service.StudentService;
import com.qduam.modules.user.dao.UserDao;
import com.qduam.modules.user.entity.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/20
 **/
@Controller
@RequestMapping(value = "/app/enroll")
public class EnrollForAppController extends BaseForAppController {

    @Resource
    EnrollService enrollService;
    @Resource
    StudentDao studentDao;
    @Resource
    UserDao userDao;

    @RequestMapping(value = "/list")
    public String findListEnroll(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Enroll enroll= (Enroll) JSONObject.toBean(jsonOb, Enroll.class);
            enroll.setStatus(DictUtils.getDictValue(enroll.getStatus(), "ENROLL"));
            List<Enroll> enrollList=enrollService.findList(enroll);
            for(Enroll a : enrollList) {
                a.setStatus(DictUtils.getDictLabel(a.getStatus(),"ENROLL"));
                Student student = studentDao.get(a.getStudent().getId());
                User user = new User();
                user.setLogname(student.getLogname());
                user = userDao.findList(user).get(0);
                student.setUser(user);
                student.setSex(DictUtils.getDictLabel(student.getSex(),"SEX"));
                student.setNation(DictUtils.getDictLabel(student.getNation(),"NATION"));
                student.setGrade(DictUtils.getDictLabel(student.getGrade(),"GRADE"));
                student.setMajor(DictUtils.getDictLabel(student.getMajor(), DictUtils.getDictId(student.getDepartment(), "DEPARTMENT"),"MAJOR", "未找到"));
                student.setDepartment(DictUtils.getDictLabel(student.getDepartment(),"DEPARTMENT"));
                a.setStudent(student);
            }
            j.put("list", enrollList);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/save")
    public synchronized String saveEnroll(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Enroll enroll = (Enroll) JSONObject.toBean(jsonOb, Enroll.class);
            enroll.setStatus(DictUtils.getDictValue(enroll.getStatus(), "ENROLL", "99"));

            if(enroll.getId() == null) {
                if(enrollService.insert(enroll)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            } else {
                if(enrollService.update(enroll)>0){
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

}
