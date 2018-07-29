/**
 * 
 */
package com.qduam.modules.article.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.qduam.common.persistence.BaseForAppController;
import com.qduam.common.utils.DictUtils;
import com.qduam.modules.assn.entity.Assn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qduam.common.json.AjaxJson;
import com.qduam.modules.article.entity.Article;
import com.qduam.modules.article.service.ArticleService;

import net.sf.json.JSONObject;

/**
 * TODO
 * @author lilinzhen
 * @version 2018年1月19日
 */
@Controller
@RequestMapping("app/article")
public class ArticleForAppController extends BaseForAppController {

	@Autowired
	ArticleService articleService;
	private AjaxJson j;

	@RequestMapping(value = "/list")
	public String findListArticle(@RequestParam("obj") String obj,HttpServletResponse response) {

		AjaxJson j = new AjaxJson();
		try{
			JSONObject jsonOb = JSONObject.fromObject(obj);
			Article article= (Article) JSONObject.toBean(jsonOb, Article.class);
			article.setSectionA(DictUtils.getDictValue(article.getSectionA(), "ARTI_SECA"));
			article.setSectionB(DictUtils.getDictValue(article.getSectionB(), "ARTI_SECB"));
			List<Article> articles=articleService.findList(article);
			for(Article a : articles) {
				a.setSectionB(DictUtils.getDictLabel(a.getSectionB(), a.getSectionA(),"ARTI_SECB", "未找到"));
				a.setSectionA(DictUtils.getDictLabel(a.getSectionA(), "ARTI_SECA"));
			}
			j.put("list", articles);
		}catch(Exception e){
			setAjaxJsonError0(j);
		}
		return renderString(response, j.getJsonStr());
	}

	@RequestMapping(value = "/assn/list")
	public String findListArticleByAssn(@RequestParam("obj") String obj,HttpServletResponse response) {

		AjaxJson j = new AjaxJson();
		try{
			JSONObject jsonOb = JSONObject.fromObject(obj);
			Assn assn= (Assn) JSONObject.toBean(jsonOb, Assn.class);
			List<Article> articles=articleService.findListByAssn(assn.getLogname());
			for(Article a : articles) {
				a.setSectionB(DictUtils.getDictLabel(a.getSectionB(), a.getSectionA(),"ARTI_SECB", "未找到"));
				a.setSectionA(DictUtils.getDictLabel(a.getSectionA(), "ARTI_SECA"));
			}
			j.put("list", articles);
		}catch(Exception e){
			setAjaxJsonError0(j);
		}
		return renderString(response, j.getJsonStr());
	}

	@RequestMapping(value = "/save")
	public synchronized String saveArticle(@RequestParam("obj") String obj,HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		try{
			JSONObject jsonOb = JSONObject.fromObject(obj);
			Article article = (Article) JSONObject.toBean(jsonOb, Article.class);
			article.setSectionA(DictUtils.getDictValue(article.getSectionA(), "ARTI_SECA"));
			article.setSectionB(DictUtils.getDictValue(article.getSectionB(), "ARTI_SECB"));

			if(article.getId() == null) {
				if(articleService.insert(article)>0){
					j.put("result", "success");
				} else {
					j.put("result", "fail");
				}
			} else {
				if(articleService.update(article)>0){
					j.put("result", "success");
				} else {
					j.put("result", "fail");
				}
			}
		}catch(Exception e){
			setAjaxJsonError0(j);
		}
		return renderString(response, j.getJsonStr());
	}

	@RequestMapping(value = "/del")
	public synchronized String delArticle(@RequestParam("obj") String obj,HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		try{
			JSONObject jsonOb = JSONObject.fromObject(obj);
			Article article = (Article) JSONObject.toBean(jsonOb, Article.class);
			if(articleService.delete(article.getId())>0){
				j.put("result", "success");
			} else {
				j.put("result", "fail");
			}
		}catch(Exception e){
			setAjaxJsonError0(j);
		}
		return renderString(response, j.getJsonStr());
	}

}
