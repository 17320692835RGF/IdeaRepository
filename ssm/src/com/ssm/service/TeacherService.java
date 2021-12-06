package com.ssm.service;

import com.ssm.po.Teacher;

/**
 * @Description
 * @Author
 * @Date 2021/9/14 0014 14:46
 */
public interface TeacherService {
    public Teacher login(String loginname,String loginpwd);
}
