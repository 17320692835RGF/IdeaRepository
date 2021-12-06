package com.interfaces;

import com.object.holiday;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface holidayDao {

    @Select("select * from holiday;")
    List<holiday> selectAllHoliday();

    @Select("select * from holiday order by rand() limit 0,#{length}")
    List<holiday> selectHoliday_R(
            @Param("length") Integer length
    );

    @Insert("insert into holiday values(#{holidayId},#{holidayName}," +
            "#{holidayDate},#{holidayReason});")
    Integer insertHoliday(holiday holiday);

    @Delete("delete from holiday where holidayId=#{holidayId}")
    Integer deleteHoliday(
            @Param("holidayId") Integer holidayId
    );

    Integer updateHoliday(holiday holiday);
}
