package com.qduam.modules.article.service;

import java.util.List;
import javax.annotation.Resource;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import com.qduam.modules.article.dao.ArticleDao;
import com.qduam.modules.article.entity.Article;

/**
 * @author lilinzhen
 * @version 2017年7月17日
 */
@Service
public class ArticleService extends CrudService<ArticleDao, Article> {

    @Resource
    private ArticleDao articleDao;
    @Resource
    private UserService userService;

    @Override
    public Article get(int id) {
        return super.get(id);
    }

    @Override
    public List<Article> findList(Article entity) {
        return super.findList(entity);
    }

    public List<Article> findListByAssn(String logname) {
        return articleDao.findListByAssn(logname);
    }

    @Override
    public int insert(Article entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Article entity) {
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
