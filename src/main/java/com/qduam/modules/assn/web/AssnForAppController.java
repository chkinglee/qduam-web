package com.qduam.modules.assn.web;

import com.qduam.common.persistence.BaseForAppController;
import com.qduam.common.json.AjaxJson;
import com.qduam.common.utils.DictUtils;
import com.qduam.modules.assn.entity.Assn;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.assn.entity.Director;
import com.qduam.modules.assn.entity.Member;
import com.qduam.modules.assn.service.AssnService;
import com.qduam.modules.assn.service.DepartService;
import com.qduam.modules.assn.service.DirectorService;
import com.qduam.modules.assn.service.MemberService;
import com.qduam.modules.student.entity.Student;
import com.qduam.modules.student.service.StudentService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/3/18
 **/
@Controller
@RequestMapping(value = "/app/assn")
public class AssnForAppController extends BaseForAppController {

    @Resource
    AssnService assnService;
    @Resource
    DepartService departService;
    @Resource
    DirectorService directorService;
    @Resource
    MemberService memberService;
    @Resource
    StudentService studentService;

    @RequestMapping(value = "/assn/list")
    public String findListAssn(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Assn assn= (Assn) JSONObject.toBean(jsonOb, Assn.class);
            assn.setLevel(DictUtils.getDictValue(assn.getLevel(), "ASSN"));
            List<Assn> assnList=assnService.findList(assn);
            for(Assn a : assnList) {
                a.setLevel(DictUtils.getDictLabel(a.getLevel(),"ASSN"));
            }
            j.put("list", assnList);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/assn/stu/list")
    public String findListAssnByStu(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Student student= (Student) JSONObject.toBean(jsonOb, Student.class);
            List<Assn> assnList=assnService.findListByStu(student.getId());
            for(Assn a : assnList) {
                a.setLevel(DictUtils.getDictLabel(a.getLevel(),"ASSN"));
            }
            j.put("list", assnList);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/assn/save")
    public synchronized String saveAssn(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Assn assn = (Assn) JSONObject.toBean(jsonOb, Assn.class);
            assn.setLevel(DictUtils.getDictValue(assn.getLevel(), "ASSN", "3"));

            if(assn.getId() == null) {
                if(assnService.insert(assn)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            } else {
                if(assnService.update(assn)>0){
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

    @RequestMapping(value = "/assn/del")
    public synchronized String delAssn(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Assn assn = (Assn) JSONObject.toBean(jsonOb, Assn.class);
            if(assnService.delete(assn.getId())>0){
                j.put("result", "success");
            } else {
                j.put("result", "fail");
            }
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/depart/get")
    public String get(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Depart depart= (Depart) JSONObject.toBean(jsonOb, Depart.class);
            depart = departService.get(depart.getId());
            depart.setLevel(DictUtils.getDictLabel(depart.getLevel(), "DEP"));
            if(depart.getDirectors() != null && depart.getDirectors().size() > 0) {
                for(Director director : depart.getDirectors()) {
                    director.setLevel(DictUtils.getDictLabel(director.getLevel(),"DIREC"));
                    director.setSex(DictUtils.getDictLabel(director.getSex(),"SEX"));
                }
            }
            if(depart.getMembers() != null && depart.getMembers().size() > 0) {
                for(Member member : depart.getMembers()) {
                    member.setStatus(DictUtils.getDictLabel(member.getStatus(),"DIREC"));
                    Student student = studentService.get(member.getStudent().getId());
                    student.setSex(DictUtils.getDictLabel(student.getSex(),"SEX"));
                    student.setNation(DictUtils.getDictLabel(student.getNation(),"NATION"));
                    student.setGrade(DictUtils.getDictLabel(student.getGrade(),"GRADE"));
                    student.setMajor(DictUtils.getDictLabel(student.getMajor(), DictUtils.getDictId(student.getDepartment(), "DEPARTMENT"),"MAJOR", "未找到"));
                    student.setDepartment(DictUtils.getDictLabel(student.getDepartment(),"DEPARTMENT"));
                    member.setStudent(student);
                }
            }

            List<Depart> departList = new ArrayList<>();
            departList.add(depart);
            j.put("list", departList);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/depart/list")
    public String findListDepart(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Depart entity= (Depart) JSONObject.toBean(jsonOb, Depart.class);
            List<Depart> list=departService.findList(entity);
            for(Depart e : list) {
                e.setLevel(DictUtils.getDictLabel(e.getLevel(),"DEP"));
                if(e.getDirectors() != null && e.getDirectors().size() > 0) {
                    for(Director director : e.getDirectors()) {
                        director.setLevel(DictUtils.getDictLabel(director.getLevel(),"DIREC"));
                        director.setSex(DictUtils.getDictLabel(director.getSex(),"SEX"));
                    }
                }
                if(e.getMembers() != null && e.getMembers().size() > 0) {
                    for(Member member : e.getMembers()) {
                        member.setStatus(DictUtils.getDictLabel(member.getStatus(),"DIREC"));
                        Student student = studentService.get(member.getStudent().getId());
                        student.setSex(DictUtils.getDictLabel(student.getSex(),"SEX"));
                        student.setNation(DictUtils.getDictLabel(student.getNation(),"NATION"));
                        student.setGrade(DictUtils.getDictLabel(student.getGrade(),"GRADE"));
                        student.setMajor(DictUtils.getDictLabel(student.getMajor(), DictUtils.getDictId(student.getDepartment(), "DEPARTMENT"),"MAJOR", "未找到"));
                        student.setDepartment(DictUtils.getDictLabel(student.getDepartment(),"DEPARTMENT"));
                        member.setStudent(student);
                    }
                }
            }
            j.put("list", list);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/depart/stu/list")
    public String findListDepartByStu(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Student entity= (Student) JSONObject.toBean(jsonOb, Student.class);
            List<Depart> list = departService.findListByStu(entity.getId());
            for(Depart e : list) {
                e.setLevel(DictUtils.getDictLabel(e.getLevel(),"DEP"));
                if(e.getDirectors() != null && e.getDirectors().size() > 0) {
                    for(Director director : e.getDirectors()) {
                        director.setLevel(DictUtils.getDictLabel(director.getLevel(),"DIREC"));
                        director.setSex(DictUtils.getDictLabel(director.getSex(),"SEX"));
                    }
                }
                if(e.getMembers() != null && e.getMembers().size() > 0) {
                    for(Member member : e.getMembers()) {
                        member.setStatus(DictUtils.getDictLabel(member.getStatus(),"DIREC"));
                        Student student = studentService.get(member.getStudent().getId());
                        student.setSex(DictUtils.getDictLabel(student.getSex(),"SEX"));
                        student.setNation(DictUtils.getDictLabel(student.getNation(),"NATION"));
                        student.setGrade(DictUtils.getDictLabel(student.getGrade(),"GRADE"));
                        student.setMajor(DictUtils.getDictLabel(student.getMajor(), DictUtils.getDictId(student.getDepartment(), "DEPARTMENT"),"MAJOR", "未找到"));
                        student.setDepartment(DictUtils.getDictLabel(student.getDepartment(),"DEPARTMENT"));
                        member.setStudent(student);
                    }
                }
            }
            j.put("list", list);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/depart/save")
    public synchronized String saveDepart(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Depart depart = (Depart) JSONObject.toBean(jsonOb, Depart.class);
            depart.setLevel(DictUtils.getDictValue(depart.getLevel(), "DEP", "2"));


            if(depart.getId() == null) {
                if(departService.insert(depart)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            } else {
                if(departService.update(depart)>0){
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

    @RequestMapping(value = "/depart/del")
    public synchronized String delDepart(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Depart depart = (Depart) JSONObject.toBean(jsonOb, Depart.class);
            if(departService.delete(depart.getId())>0){
                j.put("result", "success");
            } else {
                j.put("result", "fail");
            }
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/director/list")
    public String findListDirector(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Director entity= (Director) JSONObject.toBean(jsonOb, Director.class);
            List<Director> list=directorService.findList(entity);
            for(Director e : list) {
                e.setLevel(DictUtils.getDictLabel(e.getLevel(),"DIREC"));
                e.setSex(DictUtils.getDictLabel(e.getSex(),"SEX"));
            }
            j.put("list", list);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/director/save")
    public synchronized String saveDirector(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Director director = (Director) JSONObject.toBean(jsonOb, Director.class);
            director.setLevel(DictUtils.getDictValue(director.getLevel(), "DIREC", "2"));
            director.setSex(DictUtils.getDictValue(director.getSex(), "SEX"));

            if(director.getId() == null) {
                if(directorService.insert(director)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            } else {
                if(directorService.update(director)>0){
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

    @RequestMapping(value = "/director/del")
    public synchronized String delDirector(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Director director = (Director) JSONObject.toBean(jsonOb, Director.class);
            if(directorService.delete(director.getId())>0){
                j.put("result", "success");
            } else {
                j.put("result", "fail");
            }
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/member/list")
    public String findListMember(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Member entity= (Member) JSONObject.toBean(jsonOb, Member.class);
            List<Member> list=memberService.findList(entity);
            for(Member e : list) {
                e.setStatus(DictUtils.getDictLabel(e.getStatus(),"MEMBER"));
                Student student = studentService.get(e.getStudent().getId());
                student.setSex(DictUtils.getDictLabel(student.getSex(),"SEX"));
                student.setNation(DictUtils.getDictLabel(student.getNation(),"NATION"));
                student.setGrade(DictUtils.getDictLabel(student.getGrade(),"GRADE"));
                student.setMajor(DictUtils.getDictLabel(student.getMajor(), DictUtils.getDictId(student.getDepartment(), "DEPARTMENT"),"MAJOR", "未找到"));
                student.setDepartment(DictUtils.getDictLabel(student.getDepartment(),"DEPARTMENT"));
                e.setStudent(student);
            }
            j.put("list", list);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/member/del")
    public synchronized String delMember(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Member member = (Member) JSONObject.toBean(jsonOb, Member.class);
            if(memberService.delete(member.getId())>0){
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
