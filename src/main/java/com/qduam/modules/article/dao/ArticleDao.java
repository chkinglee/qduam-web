/**
 * 
 */
package com.qduam.modules.article.dao;

import java.util.List;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.article.entity.Article;

/**
 * @author lilinzhen
 * @version 2017年7月17日
 */
@MybatisDao
public interface ArticleDao extends CrudDao<Article> {

    @Override
    Article get(int id);

    @Override
    List<Article> findList(Article entity);

    @Override
    List<Article> findAllList(Article entity);

    @Override
    int insert(Article entity);

    @Override
    int update(Article entity);

    @Override
    int delete(int id);

    List<Article> findListByAssn(String logname);
}
