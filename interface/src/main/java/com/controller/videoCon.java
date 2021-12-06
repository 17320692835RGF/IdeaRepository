package com.controller;

import com.interfaces.videoDao;
import com.object.video;
import com.result.Result;
import com.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class videoCon {

    private Result result=new Result();
    private String objectName="视频";

    @ResponseBody
    @RequestMapping(value="/selectAllVideo",
            method={RequestMethod.GET})
    public Result selectAllVideo(String type,Integer length){
        Result result=new Result();
        SqlSession session=new MyUtils().getSession();
        videoDao dao=session.getMapper(videoDao.class);
        try{
            if (type==null){
                List<video> videos = dao.selectAllVideo();
                result.setSelects(videos,objectName);
            }else if(type.equals("r") &&length!=null){
                List<video> videos = dao.selectAllVideo_R(length);
                result.setSelects(videos,objectName);
            }else{
                result.setStatus(400);
                result.setData("链接参数错误");
            }
        }catch(Exception e){
            result.setExcept("selectAllVideo");
        }
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/insertVideo",
            method = {RequestMethod.POST,RequestMethod.GET})
    public Result insertVideo(video video){
        SqlSession session=new MyUtils().getSession_Auto();
        videoDao dao=session.getMapper(videoDao.class);
        try{
            Integer integer = dao.insertVideo(video);
            result.setInsert(integer,objectName,video);
        }catch(Exception e){
            result.setExcept("insertVideo");
        }
        session.close();
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/deleteVideo",
            method={RequestMethod.GET,RequestMethod.POST})
    public Result deleteVideo(Integer videoId){
        SqlSession session=new MyUtils().getSession_Auto();
        videoDao dao=session.getMapper(videoDao.class);
        try{
            Integer integer = dao.deleteVideo(videoId);
            result.setDelete(integer,objectName,String.valueOf(videoId));
        }catch(Exception e){
            result.setExcept("deleteVideo");
        }
        session.close();
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/updateVideo",
            method={RequestMethod.GET,RequestMethod.POST})
    public Result updateVideo(video video){
        SqlSession session=new MyUtils().getSession_Auto();
        videoDao dao=session.getMapper(videoDao.class);
        try{
            Integer integer = dao.updateVideo(video);
            result.setUpdate(integer,objectName,
                    String.valueOf(video.getVideoId()));
        }catch(Exception e){
            result.setExcept("updateVideo");
        }
        session.close();
        return result;
    }
}
