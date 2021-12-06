package com.interfaces;

import com.object.comments;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface commentsDao {

    @Select("select * from comments where commentObject=#{commentObject}")
    List<comments> selectAllComments_type(
           @Param("commentObject") String type
    );

    @Insert("insert into comments values(#{commentId},#{commentTxt},#{commentDate}," +
            "#{userCount},#{commentObject})")
    Integer insertComments(comments comments);

    @Delete("delete from comments where commentId=#{commentId}")
    Integer deleteComments_cid(
           @Param("commentId") Integer commentId
    );

    @Delete("delete from comments where userCount=#{userCount}")
    Integer deleteComments_uid(
            @Param("userCount") String userCount
    );


}
