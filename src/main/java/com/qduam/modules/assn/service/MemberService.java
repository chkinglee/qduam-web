package com.qduam.modules.assn.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.DepartDao;
import com.qduam.modules.assn.dao.MemberDao;
import com.qduam.modules.assn.entity.Member;
import com.qduam.modules.student.dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/3/18
 **/
@Service
public class MemberService extends CrudService<MemberDao, Member> {

    @Resource
    private MemberDao memberDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private DepartDao departDao;

    @Override
    public Member get(int id) {
        Member member = memberDao.get(id);
        member.setStudent(studentDao.get(member.getStudent().getId()));
        member.setDepart(departDao.get(member.getDepart().getId()));
        return member;
    }

    @Override
    public List<Member> findList(Member entity) {
        List<Member> memberList = memberDao.findList(entity);
        for(int i = 0; i < memberList.size(); i ++){
            memberList.set(i, get(memberList.get(i).getId()));
        }
        return memberList;
    }

    @Override
    public int insert(Member entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Member entity) {
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
