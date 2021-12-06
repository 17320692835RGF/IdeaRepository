package com.ssm.controller;

import com.ssm.po.Course;
import com.ssm.po.GradeEx;
import com.ssm.service.CourseService;
import com.ssm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Description
 * @Author
 * @Date 2021/9/14 0014 15:30
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private GradeService gradeService;

    @RequestMapping("/toGradeList")
    public ModelAndView toGradeList() throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        List<GradeEx> gradeExes=gradeService.findAllGradeEx();
        modelAndView.addObject("gradeExes",gradeExes);
        modelAndView.setViewName("teacher/gradeList");
        return modelAndView;
    }
    @RequestMapping("/courseSearch")
    public ModelAndView courseSearch(String keyword) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        List<Course> courses=courseService.findAllByKeyword(keyword);
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("teacher/courseList");
        return modelAndView;
    }
    @RequestMapping("/courseUpd")
    public String courseUpd(
            Course course,
            HttpServletResponse response) throws Exception{
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out=response.getWriter();
        courseService.upd(course);
        out.println("<script type=\"text/javascript\">top.mainFrame.location='toCourseList.action';</script>");
        return null;//"redirect:/teacher/toCourseList.action";
    }
    @RequestMapping("/toCourseUpd")
    public ModelAndView toCourseUpd(int id) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Course course=courseService.findOne(id);
        modelAndView.addObject("course",course);
        modelAndView.setViewName("teacher/courseUpd");
        return modelAndView;
    }
    @RequestMapping("/courseDel")
    public String courseDel(int id) throws Exception{
        courseService.del(id);
        return "redirect:/teacher/toCourseList.action";
    }
    @RequestMapping("/toCourseList")
    public ModelAndView toCourseList() throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        List<Course> courses=courseService.findAll();
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("teacher/courseList");
        return modelAndView;
    }
    @RequestMapping("/courseAdd")
    public String courseAdd(Course course) throws Exception{
        courseService.add(course);
        return "redirect:/teacher/toCourseList.action";
    }
    @RequestMapping("/courseAddJSP")
    public String courseAddJSP() throws Exception{
        return "teacher/courseAdd";
    }
    @RequestMapping("/welcomeJSP")
    public String welcomeJSP() throws Exception{
        return "teacher/welcome";
    }
}
