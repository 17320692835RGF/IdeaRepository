package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MyUtils {

    private static SqlSessionFactory sessionFactory;
    static{
        String mybatis="mybatis.xml";
        try {
            InputStream inputStream= Resources.getResourceAsStream(mybatis);
            SqlSessionFactoryBuilder sessionFactoryBuilder=new SqlSessionFactoryBuilder();
            sessionFactory= sessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SqlSession getSession(){
        return sessionFactory.openSession();
    }

    public SqlSession getSession_Auto(){
        return sessionFactory.openSession(true);
    }
}
