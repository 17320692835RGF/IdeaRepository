package com.ssm.service.impl;

import com.ssm.mapper.CourseMapper;
import com.ssm.mapper.CourseMapperEx;
import com.ssm.po.Course;
import com.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description
 * @Author
 * @Date 2021/9/15 0015 09:24
 */
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseMapperEx courseMapperEx;


    @Override
    public void add(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public List<Course> findAll() {
        return courseMapper.selectByExample(null);
    }

    @Override
    public void del(int id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Course findOne(int id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public void upd(Course course) {
        courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public List<Course> findAllByKeyword(String keyword) {
        return courseMapperEx.findAllByKeyword(keyword);
    }

}
