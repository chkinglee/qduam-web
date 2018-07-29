/**
 * 
 */
package com.qduam.modules.student.service;

import javax.annotation.Resource;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.entity.Assn;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.assn.entity.Member;
import com.qduam.modules.assn.service.AssnService;
import com.qduam.modules.assn.service.DepartService;
import com.qduam.modules.assn.service.MemberService;
import com.qduam.modules.enroll.entity.Enroll;
import com.qduam.modules.enroll.service.EnrollService;
import com.qduam.modules.user.entity.User;
import com.qduam.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import com.qduam.modules.student.dao.StudentDao;
import com.qduam.modules.student.entity.Student;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2017年7月31日
 */
@Service
public class StudentService extends CrudService<StudentDao,Student>{

    @Resource
    private StudentDao studentDao;
    @Resource
    private MemberService memberService;
    @Resource
    private EnrollService enrollService;
    @Resource
    private UserService userService;
    @Resource
    private AssnService assnService;
    @Resource
    private DepartService departService;

    @Override
    public Student get(int id) {
        Student student = studentDao.get(id);

        User user = new User();
        user.setLogname(student.getLogname());
        if(userService.findList(user) != null && userService.findList(user).size() > 0) {
            student.setUser(userService.findList(user).get(0));
        }

        Member member = new Member();
        member.setStudent(student);
        student.setMembers(memberService.findList(member));

        Enroll enroll = new Enroll();
        enroll.setStudent(student);
        student.setEnrolls(enrollService.findList(enroll));


        Integer friendsnum = 0;
        for(Member m : student.getMembers()) {
            Depart depart = departService.get(m.getDepart().getId());
            Assn assn = assnService.get(depart.getAssn().getId());
            friendsnum += assn.getMembercount();
        }
        student.setFriendsnum(friendsnum);

        return student;
    }

    @Override
    public List<Student> findList(Student entity) {
        List<Student> studentList = studentDao.findList(entity);
        for(int i = 0; i < studentList.size(); i ++) {
            studentList.set(i, get(studentList.get(i).getId()));
        }
        return studentList;
    }

    @Override
    public int insert(Student entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Student entity) {
        return super.update(entity);
    }

    @Override
    public int delete(int id) {
        return super.delete(id);
    }

    @Override
    public int deleteAll(int[] ids) {
        return super.deleteAll(ids);
    }
}
