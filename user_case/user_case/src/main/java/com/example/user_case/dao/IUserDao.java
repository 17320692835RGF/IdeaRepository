package com.example.user_case.dao;

import com.example.user_case.domain.User;

import java.util.List;
import java.util.Map;

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
