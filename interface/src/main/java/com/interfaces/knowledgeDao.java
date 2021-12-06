package com.interfaces;

import com.object.knowledge;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface knowledgeDao {
    @Select("select * from knowledge;")
    List<knowledge> selectAllKnowledge();

    @Select("select * from knowledge order by rand() limit 0,#{length};")
    List<knowledge> selectAllKnowledge_R(Integer integer);

    @Insert("insert into knoledge values(#{knowledgeId},#{knowledgeName},#{knowledgeUrl});")
    Integer insertKnowledge(knowledge knowledge);

    @Delete("delete from knowledge where knowledgeId=#{knowledgeId}")
    Integer deleteKnowledge(Integer knowledgeId);

    Integer updateKnowledge(knowledge knowledge);
}
