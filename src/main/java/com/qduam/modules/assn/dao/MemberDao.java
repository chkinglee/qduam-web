package com.qduam.modules.assn.dao;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.assn.entity.Member;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/3/14
 **/
@MybatisDao
public interface MemberDao extends CrudDao<Member>{

    @Override
    Member get(int id);

    @Override
    List<Member> findList(Member entity);

    @Override
    List<Member> findAllList(Member entity);

    @Override
    int insert(Member entity);

    @Override
    int update(Member entity);

    @Override
    int delete(int id);
}
