package com.qduam.modules.assn.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.MemberDao;
import com.qduam.modules.assn.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/3/18
 **/
@Service
public class MemberService extends CrudService<MemberDao, Member> {

    @Override
    public Member get(int id) {
        return super.get(id);
    }

    @Override
    public List<Member> findList(Member entity) {
        return super.findList(entity);
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
