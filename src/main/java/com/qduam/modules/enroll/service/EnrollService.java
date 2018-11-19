/**
 * 
 */
package com.qduam.modules.enroll.service;

import java.util.List;

import javax.annotation.Resource;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.DepartDao;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.assn.service.DepartService;
import com.qduam.modules.student.dao.StudentDao;
import com.qduam.modules.student.entity.Student;
import com.qduam.modules.user.entity.User;
import com.qduam.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import com.qduam.modules.enroll.dao.EnrollDao;
import com.qduam.modules.enroll.entity.Enroll;


/**
 * @author lilinzhen
 * @version 2017年8月2日
 */
@Service
public class EnrollService extends CrudService<EnrollDao, Enroll>{

	@Resource
	private EnrollDao enrollDao;
	@Resource
	private StudentDao studentDao;
	@Resource
	private DepartDao departDao;
	@Resource
	private UserService userService;

	@Override
	public Enroll get(int id) {
		Enroll enroll = enrollDao.get(id);

		Student student = studentDao.get(enroll.getStudent().getId());
		User user = new User();
		user.setLogname(student.getLogname());

		List<User> userList = userService.findList(user);
		if(userList != null && userList.size() > 0) {
			student.setUser(userList.get(0));
		}

        Depart depart = departDao.get(enroll.getDepart().getId());
		user.setLogname(depart.getLogname());
		userList = userService.findList(user);


		enroll.setStudent(student);
		enroll.setDepart(depart);

		return enroll;
	}

	@Override
	public List<Enroll> findList(Enroll entity) {
		List<Enroll> enrollList = enrollDao.findList(entity);

		for(int i = 0; i < enrollList.size(); i ++) {
			enrollList.set(i, get(enrollList.get(i).getId()));
		}
		return enrollList;
	}

	@Override
	public int insert(Enroll entity) {
		return super.insert(entity);
	}

	@Override
	public int update(Enroll entity) {
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
