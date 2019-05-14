package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.BreakExerciseDTO;
import com.njit.stusystem.model.Breakexercisecheck;
import com.njit.stusystem.model.BreakexercisecheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BreakexercisecheckMapper {

    @Select("SELECT\n" +
            "b.id,\n" +
            "b.school_year,\n" +
            "b.`week`,\n" +
            "b.create_time,\n" +
            "b.stu_id,\n" +
            "b.later,\n" +
            "b.eye_exercises,\n" +
            "b.pre_exercises,\n" +
            "b.queue_neat,\n" +
            "b.action_standard,\n" +
            "stu.student_name\n" +
            "FROM\n" +
            "tb_student AS stu ,\n" +
            "tb_breakexercisecheck AS b\n" +
            "WHERE\n" +
            "stu.id = b.stu_id AND\n" +
            "stu.teacher_id = #{id} AND\n" +
            "b.school_year = #{year} AND\n" +
            "b.`week` = #{week}")
    List<BreakExerciseDTO> selectByIdAndYearAndWeek(@Param("id") int id, @Param("week") String week, @Param("year") String year);

    long countByExample(BreakexercisecheckExample example);

    int deleteByExample(BreakexercisecheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Breakexercisecheck record);

    int insertSelective(Breakexercisecheck record);

    List<Breakexercisecheck> selectByExample(BreakexercisecheckExample example);

    Breakexercisecheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Breakexercisecheck record, @Param("example") BreakexercisecheckExample example);

    int updateByExample(@Param("record") Breakexercisecheck record, @Param("example") BreakexercisecheckExample example);

    int updateByPrimaryKeySelective(Breakexercisecheck record);

    int updateByPrimaryKey(Breakexercisecheck record);
}