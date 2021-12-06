package com.ssm.controller;

import com.ssm.po.Teacher;
import com.ssm.service.AdminService;
import com.ssm.service.StudentService;
import com.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @Description
 * @Author
 * @Date 2021/9/14 0014 14:52
 */
@Controller
public class LoginController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public ModelAndView login(
            HttpServletResponse response,
            HttpSession session,
            String logintype,
            String loginname,
            String loginpwd
    ) throws Exception{
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out=response.getWriter();

        ModelAndView modelAndView=new ModelAndView();
        //账号类型不同，登录的跳转也不同
        if("tea".equals(logintype)){
            Teacher teacher=teacherService.login(loginname,loginpwd);
            if(teacher!=null){
                session.setAttribute("teacher",teacher);
                modelAndView.setViewName("teacher/index");
            }else{
                out.println("<script type=\"text/javascript\">alert(\"账号密码有误，请重新尝试！\");top.location=\"login.jsp\";</script>");
                return null;//注意，通过js跳转这里一定要返回null
            }
        }else if("stu".equals(logintype)){
            //学生登录，略
        }else{
            //管理员登录，略
        }
        return modelAndView;
    }
}
