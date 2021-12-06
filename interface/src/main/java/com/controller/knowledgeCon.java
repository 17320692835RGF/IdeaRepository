package com.controller;

import com.interfaces.knowledgeDao;
import com.object.knowledge;
import com.result.Result;
import com.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class knowledgeCon {
    private Result result=new Result();
    private String objectName="知识";

    @ResponseBody
    @RequestMapping(value="/selectAllKnowledge",
            method={RequestMethod.GET})
    public Result selectKnowledge(String type, Integer length){
        SqlSession session=new MyUtils().getSession();
        knowledgeDao dao=session.getMapper(knowledgeDao.class);
        try{
            if (type==null){
                List<knowledge> knowledges = dao.selectAllKnowledge();
                result.setSelects(knowledges,objectName);
            }else if(type.equals("r")&& length!=null){
                List<knowledge> knowledges = dao.selectAllKnowledge_R(length);
                result.setSelects(knowledges,objectName);
            }else{
                result.setStatus(400);
                result.setData("链接参数错误");
            }
        }catch(Exception e){
            result.setExcept("selectKnowledges");
        }
        session.close();
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/insertKnowledge",
            method={RequestMethod.POST,RequestMethod.GET})
    public Result insertKnowledge(knowledge knowledge){
        SqlSession session=new MyUtils().getSession_Auto();
        knowledgeDao dao=session.getMapper(knowledgeDao.class);
        try{
            Integer integer = dao.insertKnowledge(knowledge);
            result.setInsert(integer,objectName,knowledge);
        }catch(Exception e){
            result.setExcept("insertKnowledge");
        }
        session.close();
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/deleteKnowledge",
            method={RequestMethod.POST,RequestMethod.GET})
    public Result deleteKnowledge(Integer knowledgeId){
        SqlSession session=new MyUtils().getSession_Auto();
        knowledgeDao dao=session.getMapper(knowledgeDao.class);
        try{
            Integer integer = dao.deleteKnowledge(knowledgeId);
            result.setInsert(integer,objectName,knowledgeId);
        }catch(Exception e){
            result.setExcept("deleteKnowledge");
        }
        session.close();
        return result;
    }

}
