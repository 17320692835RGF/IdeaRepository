package com.example.user_case.dao.impl;

import com.example.user_case.dao.IUserDao;
import com.example.user_case.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    IUserDao dao = new UserDaoImpl();
    @Test
    void findAll() {
        List<User> userList = dao.findAll();
        for (User user : userList)
            System.out.println(user);
    }
}