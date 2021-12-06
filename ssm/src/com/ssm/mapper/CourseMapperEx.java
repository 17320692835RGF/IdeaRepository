package com.ssm.mapper;

import com.ssm.po.Course;

import java.util.List;

/**
 * @Description
 * @Author
 * @Date 2021/9/15 0015 15:18
 */
public interface CourseMapperEx {
    public List<Course> findAllByKeyword(String keyword);
}
