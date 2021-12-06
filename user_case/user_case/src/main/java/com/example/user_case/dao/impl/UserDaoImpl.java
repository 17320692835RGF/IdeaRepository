package com.example.user_case.dao.impl;

import com.example.user_case.dao.IUserDao;
import com.example.user_case.domain.User;
import com.example.user_case.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 17:41 2021/8/22
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public class UserDaoImpl implements IUserDao {
    private  JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null, null)";
        int i = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        System.out.println("受影响的行数"+i);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, gender=?, age=?, address=?, qq=?, email=? where id = ?";
        int i = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        System.out.println("受影响的行数"+i);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        int i = template.update(sql, id);
        System.out.println("受影响的行数"+i);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username=? and password=?";

            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "SELECT * FROM user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet(); // 获取所有键的集合
        ArrayList<Object> params = new ArrayList<>();
        // 支持模糊查询
        for (String key: keySet){

            // 排除 currentPage rows
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            // SELECT * FROM user where 1=1 AND  name LIKE '%田%' LIMIT 0, 2
            String value =  condition.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" AND " + key + " LIKE ? ");
                params.add("%" + value + "%");
            }
        }
        sb.append(" limit ?, ?");
        sql = sb.toString();
        params.add(start); // 起始页
        params.add(rows); // 一页几条数据
        System.out.println("sqlfindByPage = " + sql);
        System.out.println("paramsList = " + params);

        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "SELECT count(*) FROM user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet(); // 获取所有键的集合
//        {name: "李"}
        ArrayList<Object> params = new ArrayList<>();
        // 支持模糊查询
        for (String key: keySet){

            // 排除 currentPage rows
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            // SELECT * FROM user where 1=1 AND  name LIKE '%田%' LIMIT 0, 2
            String value =  condition.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" AND " + key + " LIKE ? ");
                params.add("%" + value + "%");
            }

        }
        System.out.println("params"+ params);
        return template.queryForObject(sb.toString(), Integer.class, params.toArray() );
    }
}
