package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.ClassroomCreateTimeDTO;
import com.njit.stusystem.dto.ClassroomDTO;
import com.njit.stusystem.dto.CreateTimeDto;
import com.njit.stusystem.model.Classroomcheck;
import com.njit.stusystem.model.ClassroomcheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ClassroomcheckMapper {

    //教师查询本班学生课堂表现（条件，教师id,学期，当前周）
    @Select("SELECT\n" +
            "class.id,\n" +
            "class.school_year,\n" +
            "class.`week`,\n" +
            "class.creat_time,\n" +
            "class.stu_id,\n" +
            "class.positive_degree,\n" +
            "class.later,\n" +
            "class.`work`,\n" +
            "class.help_classmates,\n" +
            "class.discussion_degree,\n" +
            "stu.student_name\n" +
            "FROM\n" +
            "tb_classroomcheck AS class ,\n" +
            "tb_student AS stu\n" +
            "WHERE\n" +
            "class.`week` = #{week} AND\n" +
            "class.school_year = #{year} AND\n" +
            "class.stu_id = stu.id AND\n" +
            "stu.teacher_id = #{id}")
    List<ClassroomDTO> selectByIdAndYearAndWeek(@Param("id") int id,@Param("week") String week,@Param("year") String year);

    @Select("SELECT\n" +
            "c.id,\n" +
            "c.school_year,\n" +
            "c.`week`,\n" +
            "c.creat_time,\n" +
            "c.stu_id,\n" +
            "c.positive_degree,\n" +
            "c.later,\n" +
            "c.`work`,\n" +
            "c.help_classmates,\n" +
            "c.discussion_degree,\n" +
            "stu.student_name\n" +
            "FROM\n" +
            "tb_student AS stu ,\n" +
            "tb_classroomcheck AS c\n" +
            "WHERE\n" +
            "stu.id = c.stu_id AND\n" +
            "c.school_year = #{year} AND\n" +
            "c.`week` = #{week} AND\n" +
            "c.stu_id = #{id}")
    List<ClassroomDTO> selectByStuIdAndYearAndWeek(@Param("year") String year,@Param("week") String week,@Param("id") int id);

    @Select("SELECT\n" +
            "tb_classroomcheck.creat_time AS time\n" +
            "FROM\n" +
            "tb_classroomcheck\n" +
            "WHERE\n" +
            "tb_classroomcheck.stu_id = #{id}")
    List<CreateTimeDto> selectClassroomTimeByStuId(@Param("id") int id);

    long countByExample(ClassroomcheckExample example);

    int deleteByExample(ClassroomcheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classroomcheck record);

    int insertSelective(Classroomcheck record);

    List<Classroomcheck> selectByExample(ClassroomcheckExample example);

    Classroomcheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classroomcheck record, @Param("example") ClassroomcheckExample example);

    int updateByExample(@Param("record") Classroomcheck record, @Param("example") ClassroomcheckExample example);

    int updateByPrimaryKeySelective(Classroomcheck record);

    int updateByPrimaryKey(Classroomcheck record);
}