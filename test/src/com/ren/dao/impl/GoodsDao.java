package com.ren.dao.impl;

import com.ren.dao.IGoodsDao;
import com.ren.entity.Goods;
import com.ren.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao implements IGoodsDao {

    @Override
    public void add(Goods stu) {
        Connection con = DBHelper.getConnection();
        String sql = "insert into Goods values(?,?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, (int)(Math.random() * 10000));
            stmt.setString(2, stu.getName());
            stmt.setString(3, stu.getAdress());
            stmt.setString(4, stu.getBroad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(con);
        }
    }

    @Override
    public List<Goods> select(Integer id) {
        Connection con = DBHelper.getConnection();
        String sql="select * from goods";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet result=stmt.executeQuery();
            List<Goods> GoodsList =new ArrayList<Goods>();
            while(result.next()){
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
                GoodsList.add(new Goods(result.getInt(1),result.getString(2),result.getString(3),result.getString(4)));
            }
            return GoodsList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(con);
        }
        return null;
    }
}
