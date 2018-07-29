package com.qduam.modules.student.web;

import com.qduam.common.json.AjaxJson;
import com.qduam.common.persistence.BaseForAppController;
import com.qduam.common.utils.DictUtils;
import com.qduam.modules.assn.dao.DepartDao;
import com.qduam.modules.assn.entity.Assn;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.assn.entity.Member;
import com.qduam.modules.assn.service.AssnService;
import com.qduam.modules.assn.service.DepartService;
import com.qduam.modules.student.entity.Student;
import com.qduam.modules.student.service.StudentService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author lilinzhen
 * @version 2018/4/22
 **/
@Controller
@RequestMapping(value = "/app/student")
public class StudentForAppController extends BaseForAppController {

    @Resource
    private StudentService studentService;
    @Resource
    private AssnService assnService;
    @Resource
    private DepartService departService;

    @RequestMapping(value = "/get")
    public String get(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Student student= (Student) JSONObject.toBean(jsonOb, Student.class);
            student = studentService.get(student.getId());
            student.setSex(DictUtils.getDictLabel(student.getSex(),"SEX"));
            student.setNation(DictUtils.getDictLabel(student.getNation(),"NATION"));
            student.setGrade(DictUtils.getDictLabel(student.getGrade(),"GRADE"));
            student.setMajor(DictUtils.getDictLabel(student.getMajor(), DictUtils.getDictId(student.getDepartment(), "DEPARTMENT"),"MAJOR", "未找到"));
            student.setDepartment(DictUtils.getDictLabel(student.getDepartment(),"DEPARTMENT"));
            List<Student> studentList = new ArrayList<>();
            studentList.add(student);
            j.put("list", studentList);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/list")
    public String findList(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Student student= (Student) JSONObject.toBean(jsonOb, Student.class);
            student.setSex(DictUtils.getDictValue(student.getSex(),"SEX"));
            student.setNation(DictUtils.getDictValue(student.getNation(),"NATION"));
            student.setGrade(DictUtils.getDictValue(student.getGrade(),"GRADE"));
            student.setMajor(DictUtils.getDictValue(student.getMajor(),"MAJOR"));
            student.setDepartment(DictUtils.getDictValue(student.getDepartment(),"DEPARTMENT"));
            List<Student> studentList=studentService.findList(student);
            for(Student a : studentList) {
                a.setSex(DictUtils.getDictLabel(student.getSex(),"SEX"));
                a.setNation(DictUtils.getDictLabel(student.getNation(),"NATION"));
                a.setGrade(DictUtils.getDictLabel(student.getGrade(),"GRADE"));
                a.setMajor(DictUtils.getDictLabel(student.getMajor(), DictUtils.getDictId(student.getDepartment(), "DEPARTMENT"),"MAJOR", "未找到"));
                a.setDepartment(DictUtils.getDictLabel(student.getDepartment(),"DEPARTMENT"));
            }
            j.put("list", studentList);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/save")
    public synchronized String save(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Student student = (Student) JSONObject.toBean(jsonOb, Student.class);
            student.setSex(DictUtils.getDictValue(student.getSex(),"SEX"));
            student.setNation(DictUtils.getDictValue(student.getNation(),"NATION"));
            student.setGrade(DictUtils.getDictValue(student.getGrade(),"GRADE"));
            student.setMajor(DictUtils.getDictValue(student.getMajor(),"MAJOR", "0"));
            student.setDepartment(DictUtils.getDictValue(student.getDepartment(),"DEPARTMENT"));

            if(student.getId() == null) {
                if(studentService.insert(student)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            } else {
                if(studentService.update(student)>0){
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
    public synchronized String del(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Student student = (Student) JSONObject.toBean(jsonOb, Student.class);
            if(studentService.delete(student.getId())>0){
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
