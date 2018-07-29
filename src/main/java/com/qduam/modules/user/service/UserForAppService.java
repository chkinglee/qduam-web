/**
 *
 */
package com.qduam.modules.user.service;

import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.assn.service.DepartService;
import com.qduam.modules.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qduam.common.json.AjaxJson;
import com.qduam.common.utils.DictUtils;
import com.qduam.modules.student.entity.Student;
import com.qduam.modules.user.dao.LoginDao;
import com.qduam.modules.user.entity.User;

import java.util.List;

/**
 * TODO
 * @author lilinzhen
 * @version 2017年12月13日
 */

@Service
public class UserForAppService {

    @Autowired
    LoginDao loginDao;
    @Autowired
    StudentService studentService;
    @Autowired
    DepartService departService;
    @Autowired
    UserService userService;

    /**
     * 根据登录名获取用户（手机端）
     * @param logname
     * @param password
     * @return
     */
    public void getUserByLogname(String logname, String password,AjaxJson j) {
        User user = new User();
        user.setLogname(logname);
        List<User> userList = userService.findList(user);
        if (userList != null && userList.size() > 0) {
            // 用户存在
            if (password.equals(userList.get(0).getPassword())) {
                // 密码相等
                j.setSuccess(true);
                j.put("list", userList);
                j.setMsg("登录成功");
            } else {
                // 密码不相等
                j.setSuccess(false);
                j.setMsg("密码错误");
            }
        } else {
            // 用户不存在
            j.setSuccess(false);
            j.setMsg("用户不存在");
        }
    }

    public void getStudent(String logname, AjaxJson j) {
        Student student = new Student();
        student.setLogname(logname);
        List<Student> studentList = studentService.findList(student);
        if (studentList != null && studentList.size() > 0) {
            // 用户存在
            student = studentList.get(0);
            student.setGrade(DictUtils.getDictLabel(student.getGrade(), "GRADE"));
            student.setSex(DictUtils.getDictLabel(student.getSex(), "SEX"));
            student.setNation(DictUtils.getDictLabel(student.getNation(), "NATION"));
            student.setDepartment(DictUtils.getDictLabel(student.getDepartment(), "DEPARTMENT"));
            student.setMajor(DictUtils.getDictLabel(student.getMajor(), "MAJOR"));
            studentList.set(0, student);
            j.setSuccess(true);
            j.put("list", studentList);
            j.setMsg("学生数据获取成功");
        } else {
            // 用户不存在
            j.setSuccess(false);
            j.setMsg("用户不存在");
        }
    }

    public void getDepart(String logname, AjaxJson j) {
        Depart depart = new Depart();
        depart.setLogname(logname);
        List<Depart> departList = departService.findList(depart);
        if (departList != null && departList.size() > 0) {
            // 用户存在
            depart = departList.get(0);
            depart.setLevel(DictUtils.getDictLabel(depart.getLevel(), "DEP"));
            departList.set(0, depart);
            j.setSuccess(true);
            j.put("list", departList);
            j.setMsg("部门数据获取成功");
        } else {
            // 用户不存在
            j.setSuccess(false);
            j.setMsg("用户不存在");
        }
    }

}
