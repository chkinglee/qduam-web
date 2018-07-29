package com.qduam.modules.sys.web;

import com.qduam.common.json.AjaxJson;
import com.qduam.common.persistence.BaseForAppController;
import com.qduam.common.utils.DictUtils;
import com.qduam.modules.sys.entity.Dict;
import com.qduam.modules.sys.entity.Guide;
import com.qduam.modules.sys.entity.Problem;
import com.qduam.modules.sys.service.DictService;
import com.qduam.modules.sys.service.GuideService;
import com.qduam.modules.sys.service.ProblemService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/5/1
 **/
@Controller
@RequestMapping(value = "/app/sys")
public class SysForAppController extends BaseForAppController {


    @Resource
    private DictService dictService;
    @Resource
    private GuideService guideService;
    @Resource
    private ProblemService problemService;


    @RequestMapping(value = "/dict/list")
    public String findListDict(@RequestParam("obj") String obj, HttpServletResponse response) {

        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);

            Dict dict= (Dict) JSONObject.toBean(jsonOb, Dict.class);
            List<Dict> dictList=dictService.findList(dict);
            j.put("list", dictList);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/guide/list")
    public String findListGuide(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Guide entity= (Guide) JSONObject.toBean(jsonOb, Guide.class);
            List<Guide> list=guideService.findList(entity);
            j.put("list", list);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/guide/save")
    public synchronized String saveGuide(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Guide guide = (Guide) JSONObject.toBean(jsonOb, Guide.class);

            if(guide.getId() == null) {
                if(guideService.insert(guide)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            } else {
                if(guideService.update(guide)>0){
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

    @RequestMapping(value = "/problem/list")
    public String findListProblem(@RequestParam("obj") String obj, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Problem entity= (Problem) JSONObject.toBean(jsonOb, Problem.class);
            List<Problem> list=problemService.findList(entity);
            j.put("list", list);
        }catch(Exception e){
            setAjaxJsonError0(j);
        }
        return renderString(response, j.getJsonStr());
    }

    @RequestMapping(value = "/problem/save")
    public synchronized String saveProblem(@RequestParam("obj") String obj,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        try{
            JSONObject jsonOb = JSONObject.fromObject(obj);
            Problem problem = (Problem) JSONObject.toBean(jsonOb, Problem.class);

            if(problem.getId() == null) {
                if(problemService.insert(problem)>0){
                    j.put("result", "success");
                } else {
                    j.put("result", "fail");
                }
            } else {
                if(problemService.update(problem)>0){
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

}
