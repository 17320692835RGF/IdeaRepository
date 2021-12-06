package com.ssm.service.impl;

import com.ssm.mapper.TeacherMapperEx;
import com.ssm.po.Teacher;
import com.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @Description
 * @Author
 * @Date 2021/9/14 0014 14:47
 */
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapperEx teacherMapperEx;

    @Override
    public Teacher login(String loginname, String loginpwd) {
        HashMap hashMap=new HashMap();
        hashMap.put("loginname",loginname);
        hashMap.put("loginpwd",loginpwd);
        return teacherMapperEx.login(hashMap);
    }
}
