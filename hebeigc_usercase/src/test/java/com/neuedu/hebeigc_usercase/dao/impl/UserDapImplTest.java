package com.neuedu.hebeigc_usercase.dao.impl;

import com.neuedu.hebeigc_usercase.dao.IUserDao;
import com.neuedu.hebeigc_usercase.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDapImplTest {
    IUserDao dao = new UserDapImpl();

    @Test
    void findAll() {
        List<User> all = dao.findAll();
        for (User user : all){
            System.out.println(user);
        }

    }
    @Test
    void add() {
        User user = new User();
        user.setName("河北工程第一帅");
        user.setAddress("邯郸");
        user.setAge(18);
        user.setEmail("ewqdewqewq@qq.com");
        user.setGender("男");
        user.setQq("4324234234");
        dao.add(user);


    }
    @Test
    void update() {
        User user = new User();
        user.setId(2);
        user.setName("河北工程大漂亮");
        user.setAddress("邯郸");
        user.setAge(18);
        user.setEmail("ewqdewqewq@qq.com");
        user.setGender("女");
        user.setQq("4324234234");
        dao.update(user);


    }
    @Test
    void delete() {

        dao.delete(28);


    }
    @Test
    void findById() {

        User user = dao.findById(1);
        System.out.println(user);



    }
}