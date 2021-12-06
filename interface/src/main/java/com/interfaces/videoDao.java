package com.interfaces;

import com.object.video;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface videoDao {

//    @Select("select * from video")
    List<video> selectAllVideo();

//    @Insert("insert into video values(#{videoId},#{videoName},#{videoUrl})")
    Integer insertVideo(video video);

//    @Delete("delete from video where videoId=#{videoId}")
    Integer deleteVideo(
            @Param("videoId") Integer videoId
    );

    @Select("select * from video order by rand() limit 0,#{length};")
    List<video> selectAllVideo_R(
            @Param("length") Integer length
    );

    Integer updateVideo(video video);
}
