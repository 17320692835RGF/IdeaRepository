package com.interfaces;

import com.object.user;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface userDao {
    //@Select("select * from user where userCount=#{userCount}")
    public user selectUser(
            @Param("userCount") String userCount
    );

    //@Insert("insert into user value(#{userCount},#{userName},#{userPasswd})")
    public Integer insertUser(
            user user
    );

    public Integer updateUser(
            user user
    );


    //@Delete("delete from user where userCount=#{userCount}")
    public Integer deleteUser(
      @Param("userCount") String userCount
    );
}
