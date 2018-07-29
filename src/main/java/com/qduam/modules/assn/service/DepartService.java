/**
 * 
 */
package com.qduam.modules.assn.service;

import javax.annotation.Resource;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.AssnDao;
import com.qduam.modules.assn.entity.Director;
import com.qduam.modules.assn.entity.Member;
import com.qduam.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import com.qduam.modules.assn.dao.DepartDao;
import com.qduam.modules.assn.entity.Depart;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2017年8月8日
 */
@Service
public class DepartService extends CrudService<DepartDao, Depart>{

	@Resource
	private DepartDao departdao;
	@Resource
	private AssnDao assnDao;
	@Resource
	private DirectorService directorService;
	@Resource
	private MemberService memberService;
	@Resource
	private UserService userService;

	@Override
	public Depart get(int id) {
		Depart depart = departdao.get(id);
		depart.setAssn(assnDao.get(depart.getAssn().getId()));

		depart.setUser(userService.findList(depart.getUser()).get(0));

		Director director = new Director();
		director.setDepart(depart);
		List<Director> directorList = directorService.findList(director);
		depart.setDirectors(directorList);

		Member member = new Member();
		member.setDepart(depart);
		List<Member> memberList = memberService.findList(member);
		depart.setMembers(memberList);

		return depart;
	}

	@Override
	public List<Depart> findList(Depart entity) {
		List<Depart> departList = departdao.findList(entity);
		for(int i = 0; i < departList.size(); i ++){
			departList.set(i, get(departList.get(i).getId()));
		}
		return departList;
	}

    public List<Depart> findListByStu(int id) {
        List<Depart> departList = departdao.findListByStu(id);
        for(int i = 0; i < departList.size(); i ++){
            departList.set(i, get(departList.get(i).getId()));
        }
        return departList;
    }

	@Override
	public int insert(Depart entity) {
		return super.insert(entity);
	}

	@Override
	public int update(Depart entity) {
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
