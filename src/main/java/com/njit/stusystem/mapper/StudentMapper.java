package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.StudentDTO;
import com.njit.stusystem.dto.TeaAndStuDTO;
import com.njit.stusystem.model.Student;
import com.njit.stusystem.model.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    /*登录验证用户名和密码，用户名为主键id*/
    @Select("select * from tb_student where id=#{id} and student_password=#{password}")
    StudentDTO selectByUsernameAndPassword(@Param("id")Integer id, @Param("password")String password);

    /*查询所有学生信息*/
    @Select("SELECT\n" +
            "tea.teacher_name,\n" +
            "tea.teacher_classname,\n" +
            "stu.id,\n" +
            "stu.student_name,\n" +
            "stu.student_password,\n" +
            "stu.student_birthday,\n" +
            "stu.student_sex,\n" +
            "stu.student_phone,\n" +
            "stu.student_address,\n" +
            "stu.student_email\n" +
            "FROM\n" +
            "tb_student AS stu\n" +
            "INNER JOIN tb_teacher AS tea ON stu.teacher_id = tea.id")
    List<TeaAndStuDTO> selectAll();

    /*根据学生email查询学生信息,ps:用于忘记密码时判断邮箱是否存在，存在返回学生信息，不存在返回null*/
    @Select("SELECT * FROM tb_student WHERE student_email=#{email}")
    StudentDTO selectByEmail(String email);

    //查询所有学生id
    @Select("SELECT tb_student.id from tb_student")
    List<Integer> selectId();

    /**根据学生id查询学生信息*/
    @Select("select * from tb_student where tb_student.id=#{id}")
    StudentDTO selectById(@Param("id") Integer id);

    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}