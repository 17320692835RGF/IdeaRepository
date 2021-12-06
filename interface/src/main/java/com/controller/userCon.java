package com.controller;

import com.interfaces.userDao;
import com.object.user;
import com.result.Result;
import com.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class userCon {
    private String objectName="用户";
    private Result result=new Result();

    @RequestMapping(value="/login",
            method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Result selectUser(String userCount,String passwd){
        SqlSession session=new MyUtils().getSession();
        userDao dao=session.getMapper(userDao.class);
        user user = dao.selectUser(userCount);
        Map<String,String> map=new HashMap<>();
        if(user!=null){
            if (user.getUserPasswd().equals(passwd)){
                result.setStatus(200);
                map.put("info","密码正确");
            }else{
                result.setStatus(401);
                map.put("info","密码错误");
            }
        }else{
            result.setStatus(400);
            map.put("info","用户不存在");
        }
        result.setData(map);
        session.close();
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/insertUser",
        method={RequestMethod.POST,RequestMethod.GET}
    )
    public Result insertUser(user user){
        SqlSession session=new MyUtils().getSession_Auto();
        userDao dao = session.getMapper(userDao.class);
        try{
            System.out.println(user.toString());
            Integer integer = dao.insertUser(user);
            result.setInsert(integer,objectName,user);
        }catch(Exception e){
            result.setExcept("insertUser");
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @RequestMapping(value="/updateUser")
    @ResponseBody
    public Result updateUser(user user){
        SqlSession session=new MyUtils().getSession_Auto();
        userDao dao = session.getMapper(userDao.class);
        Integer integer = dao.updateUser(user);
        result.setUpdate(integer,objectName,user.getUserCount());
        session.close();
        return result;
    }

    @RequestMapping(value="/deleteUser",
            method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Result userDelete(String userCount){
        Result result=new Result();
        SqlSession session=new MyUtils().getSession_Auto();
        userDao dao=session.getMapper(userDao.class);
        Integer integer = dao.deleteUser(userCount);
        result.setDelete(integer,objectName,userCount);
        session.close();
        return result;
    }
}
