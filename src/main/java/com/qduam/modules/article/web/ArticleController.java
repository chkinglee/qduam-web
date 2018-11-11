package com.qduam.modules.article.web;

import com.qduam.common.persistence.BaseController;
import com.qduam.modules.article.entity.Article;
import com.qduam.modules.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2018/11/11
 **/
@Controller
@RequestMapping("article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询文章列表
     * @param model
     * @param article
     * @return
     */
    @RequestMapping(value = {"/list", "/", ""})
    private String findList(Model model, Article article) {
        List<Article> articleList = articleService.findList(article);
        model.addAttribute("articleList", articleList);
        return "article/list";
    }

    /**
     * 查询文章详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Article article = articleService.get(id);
        model.addAttribute("article", article);
        return "article/view";
    }

    /**
     * 删除文章
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = articleService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/article/list";
    }

    /**
     * 编辑文章（添加或修改）
     * @param model
     * @param article
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Article article) {
        if (id != null) {
            article = articleService.get(id);
        }
        model.addAttribute("article", article);
        return "article/edit";
    }

    /**
     * 保存文章（添加或修改）
     * @param article
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/save")
    private String save(Article article, RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (article.getId() == null) {
            successNum = articleService.insert(article);
        } else {
            successNum = articleService.update(article);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/article/list";
    }
}
