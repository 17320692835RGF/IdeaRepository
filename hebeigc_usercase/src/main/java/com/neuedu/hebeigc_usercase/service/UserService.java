package com.neuedu.hebeigc_usercase.service;

import com.neuedu.hebeigc_usercase.domain.PageBean;
import com.neuedu.hebeigc_usercase.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 15:01 2021/8/30
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public interface UserService {
    // 查询所有用户信息
    public List<User> findAll();

    public void addUser(User user);

    public void update(User user);

    public void deleteUser(String id);

    public User findUserById(String id);

    public User login(User user);

    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition );
    public void deleteSelectedUser(String[] ids);
}
