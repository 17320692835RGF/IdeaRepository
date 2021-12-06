package com.ssm.service.impl;

import com.ssm.mapper.GradeMapperEx;
import com.ssm.po.GradeEx;
import com.ssm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description
 * @Author
 * @Date 2021/9/16 0016 14:45
 */
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapperEx gradeMapperEx;
    @Override
    public List<GradeEx> findAllGradeEx() {
        return gradeMapperEx.findAllGradeEx();
    }
}
