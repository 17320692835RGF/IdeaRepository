package com.interfaces;

import com.object.news;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface newsDao {

    //@Select("select * from news;")
    List<news> selectAllNews();

    @Select("select * from news order by rand() limit 0,#{length};")
    List<news> selectRandomNews(
            @Param("length") Integer length
    );


    @Insert("insert into news values(#{newsId},#{newsName}," +
            "#{newsFace},#{newsDate},#{newsFrom},#{newsUrl},#{newsAgencyUrl});")
    Integer insertNews(news news);

    @Delete("delete from news where newsId=#{newsId}")
    Integer deleteNews(Integer newsId);

}
