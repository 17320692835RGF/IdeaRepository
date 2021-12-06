package com.controller;

import com.interfaces.lawDao;
import com.object.law;
import com.result.Result;
import com.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class lawCon {
    private String objectName="法律";
    private Result result=new Result();


    @RequestMapping("/selectAllLaw")
    @ResponseBody
    public Result selectKnowledges(String type, Integer length){
        SqlSession session=new MyUtils().getSession();
        lawDao dao=session.getMapper(lawDao.class);
        try{
            if (type==null){
                List<law> laws = dao.selectAllLaw();
                result.setSelects(laws,objectName);
            }else if(type.equals("r")&& length!=null){
                List<law> laws = dao.selectAllLaw_R(length);
                result.setSelects(laws,objectName);
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
    @RequestMapping(value="/deleteLaw",
            method={RequestMethod.GET,RequestMethod.POST})
    public Result deleteLaw(int lawId){

        SqlSession session=new MyUtils().getSession();
        lawDao dao=session.getMapper(lawDao.class);
        try{
            Integer integer = dao.deleteLaw(lawId);
            result.setDelete(integer,objectName,String.valueOf(lawId));
        }catch(Exception e){
            result.setExcept("deleteLaw");
        }
        session.close();
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/insertLaw",
            method={RequestMethod.GET,RequestMethod.POST})
    public Result insertLaw(law law){

        SqlSession session=new MyUtils().getSession();
        lawDao dao=session.getMapper(lawDao.class);
        try{
            Integer integer = dao.insertLaw(law);
            result.setInsert(integer,objectName,law);
        }catch(Exception e){
            result.setExcept("deleteLaw");
        }
        session.close();
        return result;
    }



}
