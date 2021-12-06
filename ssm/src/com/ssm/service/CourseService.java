package com.ssm.service;

import com.ssm.po.Course;

import java.util.List;

/**
 * @Description
 * @Author
 * @Date 2021/9/15 0015 09:24
 */
public interface CourseService {
    public void add(Course course);
    public List<Course> findAll();
    public void del(int id);
    public Course findOne(int id);
    public void upd(Course course);
    public List<Course> findAllByKeyword(String keyword);
}
