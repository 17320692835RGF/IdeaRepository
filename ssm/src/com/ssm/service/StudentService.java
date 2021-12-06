package com.ssm.service;

import com.ssm.po.Student;

/**
 * @Description
 * @Author
 * @Date 2021/9/14 0014 14:53
 */
public interface StudentService {
    public Student login(String loginname, String loginpwd);
}
