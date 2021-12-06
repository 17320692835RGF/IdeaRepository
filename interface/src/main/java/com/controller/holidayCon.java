package com.controller;

import com.interfaces.holidayDao;
import com.object.holiday;
import com.result.Result;
import com.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class holidayCon {
    private Result result=new Result();
    private String objectName="节日";
    @RequestMapping(value="/selectHolidays",method={RequestMethod.GET})
    @ResponseBody
    public Result selectHolidays(String type, Integer length){
        SqlSession session=new MyUtils().getSession();
        holidayDao dao=session.getMapper(holidayDao.class);
        try{
            if (type==null){
                List<holiday> holidays = dao.selectAllHoliday();
                result.setSelects(holidays,objectName);
            }else if(type.equals("r")&& length!=null){
                List<holiday> holidays = dao.selectHoliday_R(length);
                result.setSelects(holidays,objectName);
            }else{
                result.setStatus(400);
                result.setData("链接参数错误");
            }
        }catch(Exception e){
            result.setExcept("selectHolidays");
        }
        session.close();
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/insertHoliday",
            method={RequestMethod.POST,RequestMethod.GET})
    public Result insertHoliday(holiday holiday){
        SqlSession session=new MyUtils().getSession_Auto();
        holidayDao dao=session.getMapper(holidayDao.class);
        try{
            Integer integer = dao.insertHoliday(holiday);
            result.setInsert(integer,objectName,holiday);
        }catch(Exception e){
            result.setExcept("insertHoliday");
        }
        session.close();
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/deleteHoliday",
            method={RequestMethod.POST,RequestMethod.GET})
    public Result deleteHoliday(Integer holidayId){
        SqlSession session=new MyUtils().getSession_Auto();
        holidayDao dao=session.getMapper(holidayDao.class);
        try {
            Integer integer = dao.deleteHoliday(holidayId);
            result.setDelete(integer,objectName,String.valueOf(holidayId));
        }catch(Exception e){
            result.setExcept("deleteHoliday");
        }
        session.close();
        return result;
    }




}
