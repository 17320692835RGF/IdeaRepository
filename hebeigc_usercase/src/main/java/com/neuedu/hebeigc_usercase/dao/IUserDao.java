package com.neuedu.hebeigc_usercase.dao;

import com.neuedu.hebeigc_usercase.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 11:24 2021/8/30
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public interface IUserDao {
    public List<User> findAll();

    public void add(User user);

    public void update(User user);

    public void delete(int id);

    public User findById(int id);

    public User findUserByUserNameAndPassword(String username, String password);

    // 分页查询
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    // 查询总记录条数
    int findTotalCount(Map<String, String[]> condition);
}
