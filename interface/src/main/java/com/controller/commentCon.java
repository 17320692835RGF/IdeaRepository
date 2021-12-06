package com.controller;

import com.interfaces.commentsDao;
import com.object.comments;
import com.result.Result;
import com.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class commentCon {
    private Result result=new Result();
    private String objectName="评论";

    @RequestMapping(value="/selectComments",
    method={RequestMethod.GET}
    )
    @ResponseBody
    public Result selectComments(String type){
        SqlSession session=new MyUtils().getSession();
        commentsDao dao=session.getMapper(commentsDao.class);
        if(type!=null){
            try{
                List<comments> comments = dao.selectAllComments_type(type);
                result.setSelects(comments,objectName);
            }catch(Exception e){
                session.close();
                result.setExcept("selectComments");
            }
        }else{
            result.setData("请求参数错误");
            result.setStatus(401);
        }
        System.out.println(result);
        session.close();
        return result;
    }

    @RequestMapping(value="/insertComments",
            method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Result insertComments(comments comments){
        SqlSession session=new MyUtils().getSession_Auto();
        commentsDao dao=session.getMapper(commentsDao.class);
        try{
            Integer integer = dao.insertComments(comments);
            result.setInsert(integer,objectName,comments);
        }catch(Exception e){
            session.close();
            result.setExcept("insertComments");
        }
        session.close();
        return result;
    }

    @RequestMapping(value="/deletComments",
            method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Result insertComments(String type,String oid){
        SqlSession session=new MyUtils().getSession_Auto();
        commentsDao dao=session.getMapper(commentsDao.class);
        try{
            if(type.equals("user")){
                Integer integer = dao.deleteComments_uid(oid);
                result.setDelete(integer,objectName,oid);
            }else if(type.equals("comment")){
                Integer integer = dao.deleteComments_cid(Integer.parseInt(oid));
                result.setDelete(integer,objectName,oid);
            }else{
                result.setStatus(404);
                result.setData("error: type.value"+type);
            }
        }
        catch(Exception e){
            session.close();
            result.setExcept("insertComments");
        }
        session.close();
        return result;
    }

}
