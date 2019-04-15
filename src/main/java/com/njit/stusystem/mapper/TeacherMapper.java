package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.TeacherDTO;
import com.njit.stusystem.model.Teacher;
import com.njit.stusystem.model.TeacherExample;
import java.util.List;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TeacherMapper {

    /*登录验证用户名和密码，用户名为主键id*/
    @Select("select * from tb_teacher where id=#{id} and teacher_password=#{password}")
    TeacherDTO selectByUsernameAndPassword(@Param("id")Integer id, @Param("password")String password);

    /*查询教师表所有信息*/
    @Select("select * from tb_teacher")
    List<Teacher> selectAll();

    /*根据教师id查询教师信息*/
    @Select("select * from tb_teacher where id=#{id}")
    TeacherDTO selectById(Integer id);

    @Update("UPDATE tb_teacher SET teacher_address='南京市江宁区' WHERE id=#{id}")
    int updateById();

    /*根据教师姓名查询教师信息*/
    @Select("select * from tb_teacher where name=#{name}")
    TeacherDTO selectByName(String name);

    /*根据教师email查询教师信息,ps:用于忘记密码时判断邮箱是否存在，存在返回教师信息，不存在返回null*/
    @Select("SELECT * FROM tb_teacher WHERE teacher_email=#{email}")
    TeacherDTO selectEmail(String email);

    /*查询所有教师id*/
    @Select("SELECT tb_teacher.id FROM tb_teacher")
    List<Integer> selectId();

    //根据班级名查询教师id
    @Select("SELECT\n" +
            "tea.id\n" +
            "FROM\n" +
            "tb_teacher AS tea\n" +
            "WHERE\n" +
            "tea.teacher_classname = #{classname}")
    int selectTeacherIdByClassName(@Param("classname") String classname);

    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}