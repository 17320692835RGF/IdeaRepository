package com.interfaces;

import com.object.law;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface lawDao {
    @Select("select * from law;")
    List<law> selectAllLaw();

    @Select("select * from law order by rand() limit 0,#{length}")
    List<law> selectAllLaw_R(
            @Param("length") Integer length
    );

    @Insert("insert into law values(#{lawId},#{lawName},#{lawUrl});")
    Integer insertLaw(law law);

    @Delete("delete from law where lawId=#{lawId};")
    Integer deleteLaw(
            @Param("lawId") Integer lawId
    );


}
