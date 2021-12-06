package com.neuedu.hebeigc_usercase.dao.impl;

import com.neuedu.hebeigc_usercase.dao.IUserDao;
import com.neuedu.hebeigc_usercase.domain.User;
import com.neuedu.hebeigc_usercase.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 11:25 2021/8/30
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public class UserDapImpl implements IUserDao {
    private  JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        //new BeanPropertyRowMapper<实体类>(实体类.class)
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void add(User user) {
        String sql = "insert into  user values(null, ?,?,?,?,?,?,null, null ) ";
        int i = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        System.out.println("i = " + i);


    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, gender=?, age=?, address=?, qq=?, email=? where id = ?";
        int i = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        System.out.println("i = " + i);

    }

    @Override
    public void delete(int id) {
        String sql = "delete  from user where id = ?";
        int i = template.update(sql, id);
        System.out.println("i = " + i);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";

        try{
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        ArrayList<Object> params = new ArrayList<>();
        // 支持模糊查询
        for (String key : keySet){
            // 排除 currentPage rows
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            // SELECT * FROM user where 1=1 AND  name LIKE '%田%' LIMIT 0, 2
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" AND " + key + "  LIKE  ?  ");
                params.add("%"  + value  + "%");
            }
        }

        sb.append(" limit ?, ?");
        sql = sb.toString();
        params.add(start);
        params.add(rows);
        System.out.println("findByPagesql = " + sql);
        System.out.println("findByPageparams = " + params);

        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        ArrayList<String> params = new ArrayList<>();
        // 支持模糊查询
        for (String key : keySet){
            // 排除 currentPage rows
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            // SELECT * FROM user where 1=1 AND  name LIKE '%田%' LIMIT 0, 2
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" AND " + key + "  LIKE  ?  ");
                params.add("%"  + value  + "%");
            }
        }
        System.out.println("params" + params);

        return template.queryForObject(sb.toString(), Integer.class,  params.toArray());
    }
}
