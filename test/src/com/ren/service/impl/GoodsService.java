package com.ren.service.impl;

import com.ren.dao.IGoodsDao;
import com.ren.dao.impl.GoodsDao;
import com.ren.entity.Goods;
import com.ren.service.IGoodsService;

import java.util.List;

public class GoodsService implements IGoodsService {

    private IGoodsDao stuDao = new GoodsDao();

    @Override
    public void add(Goods goods) {
        stuDao.add(goods);
    }

    @Override
    public List<Goods> select(Integer id) {
        return stuDao.select(id);
    }

}
