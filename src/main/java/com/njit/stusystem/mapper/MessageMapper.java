package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.MessageDTO;
import com.njit.stusystem.dto.UnReadCountsDTO;
import com.njit.stusystem.model.Message;
import com.njit.stusystem.model.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MessageMapper {

    //根据教师id查询消息
    @Select("SELECT\n" +
            "tb_message.avatar,\n" +
            "tb_message.title,\n" +
            "tb_message.datetime,\n" +
            "tb_message.type,\n" +
            "tb_message.id\n" +
            "FROM\n" +
            "tb_message ,\n" +
            "tb_teacher\n" +
            "WHERE\n" +
            "tb_teacher.id = tb_message.user_id AND\n" +
            "tb_teacher.id = #{id} AND\n" +
            "tb_message.type = #{messageType}\n" +
            "ORDER BY\n" +
            "tb_message.datetime DESC")
    List<MessageDTO> selectByTeacherId(@Param("id") Integer id,@Param("messageType") String type);

    /**根据学生id查询消息*/
    @Select("SELECT\n" +
            "tb_message.id,\n" +
            "tb_message.avatar,\n" +
            "tb_message.title,\n" +
            "tb_message.datetime,\n" +
            "tb_message.type\n" +
            "FROM\n" +
            "tb_message ,\n" +
            "tb_student\n" +
            "WHERE\n" +
            "tb_student.id = tb_message.user_id AND\n" +
            "tb_student.id = #{id} AND\n" +
            "tb_message.type = #{messageType}\n" +
            "ORDER BY\n" +
            "tb_message.datetime DESC")
    List<MessageDTO> selectByStuId(@Param("id") Integer id,@Param("messageType") String type);

    //根据学生或教师id修改消息未读状态
    @Update("UPDATE tb_message SET status='0' WHERE user_id=#{id}")
    int updateStatusByUserId(@Param("id") Integer id);

    //根据教师id查询该教师未读消息数量
    @Select("SELECT\n" +
            "count(*) AS count\n" +
            "FROM\n" +
            "tb_message ,\n" +
            "tb_teacher\n" +
            "WHERE\n" +
            "tb_teacher.id = #{id} AND\n" +
            "tb_message.status = 1 AND\n" +
            "tb_teacher.id = tb_message.user_id")
    UnReadCountsDTO selectUnReadCounts(@Param("id") Integer id);

    //根据学生id查询该学生未读消息数量
    @Select("SELECT\n" +
            "count(*) AS count\n" +
            "FROM\n" +
            "tb_message ,\n" +
            "tb_student\n" +
            "WHERE\n" +
            "tb_student.id = #{id} AND\n" +
            "tb_message.status = 1 AND\n" +
            "tb_student.id = tb_message.user_id")
    UnReadCountsDTO selectUnReadCountsByStuId(@Param("id") Integer id);

    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}