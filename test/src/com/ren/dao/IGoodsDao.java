package com.ren.dao;

import com.ren.entity.Goods;

import java.util.List;

public interface IGoodsDao {

    void add(Goods stu);
    List<Goods> select(Integer id);
}
