package com.ren.service;

import com.ren.entity.Goods;

import java.util.List;

public interface IGoodsService {

    void add(Goods student);
    List<Goods> select(Integer id);
}
