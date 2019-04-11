package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.CourseDTO;
import com.njit.stusystem.dto.StuAndCourseDTO;
import com.njit.stusystem.dto.StuCourseOfYearDTO;
import com.njit.stusystem.model.Course;
import com.njit.stusystem.model.CourseExample;
import java.util.List;

import com.sun.imageio.plugins.common.I18N;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface CourseMapper {

    /*查询每个学生的学号和对应的成绩学年*/
    @Select("SELECT\n" +
            "tb_student.id,\n" +
            "tb_student.student_name,\n" +
            "tb_course.school_year\n" +
            "FROM\n" +
            "tb_student ,\n" +
            "tb_course\n" +
            "WHERE\n" +
            "tb_student.id = tb_course.stu_id AND\n" +
            "tb_student.id = #{studentId}")
    List<StuCourseOfYearDTO> selectStuIdAndYearByStuId(@Param("studentId") Integer studentId);

    /*查询班主任本班学生的成绩*/
    @Select("SELECT\n" +
            "stu.id AS 'stuId',\n" +
            "stu.student_name,\n" +
            "\n" +
            "course.physics,\n" +
            "course.math,\n" +
            "course.english,\n" +
            "course.biology,\n" +
            "course.chinese,\n" +
            "course.chemistry,\n" +
            "course.id,\n" +
            "stu.teacher_id,\n" +
            "course.school_year\n" +
            "FROM\n" +
            "tb_teacher\n" +
            "INNER JOIN tb_student AS stu ON stu.teacher_id = tb_teacher.id ,\n" +
            "tb_course AS course\n" +
            "WHERE\n" +
            "stu.id = course.stu_id AND\n" +
            "course.school_year = #{year} AND\n" +
            "tb_teacher.id = #{id}")
    List<StuAndCourseDTO> selectCourseByYears(@Param("year") Integer year, @Param("id")Integer id);

    /*根据学生id和学年，查询学生每学期各科成绩*/
    @Select("SELECT\n" +
            "stu.student_name,\n" +
            "stu.id,\n" +
            "tea.teacher_classname,\n" +
            "course.physics,\n" +
            "course.math,\n" +
            "course.english,\n" +
            "course.biology,\n" +
            "course.chinese,\n" +
            "course.chemistry,\n" +
            "course.school_year\n" +
            "FROM\n" +
            "tb_student AS stu\n" +
            "INNER JOIN tb_teacher AS tea ON stu.teacher_id = tea.id ,\n" +
            "tb_course AS course\n" +
            "WHERE\n" +
            "course.stu_id = stu.id AND\n" +
            "stu.id = #{id} AND\n" +
            "course.school_year = #{year}")
    StuAndCourseDTO selectCourseByStuIdAndYear(@Param("id") Integer id,@Param("year")Integer year);

    /*根据教师id和学年，查询班级各个分段的具体人数*/
    @Select("SELECT\n" +
            "count(*)\n" +
            "FROM\n" +
            "tb_course AS course ,\n" +
            "tb_student\n" +
            "INNER JOIN tb_teacher ON tb_student.teacher_id = tb_teacher.id\n" +
            "WHERE\n" +
            "course.stu_id = tb_student.id AND\n" +
            "course.physics+course.chinese+course.english+course.math+course.chemistry+course.biology BETWEEN #{min} AND #{max} AND\n" +
            "course.school_year = #{year} AND\n" +
            "tb_teacher.id = #{id}  ")
    int selectCount(Integer min, Integer max, Integer year,Integer id);

    /*根据学生id和姓名，教师id，查询该学生每学年度的总分*/
    @SelectProvider(type = CourseSqlProvider.class,method = "selectCourseByYear")
    List<Integer>  selectCourseByYear(@Param("teacherId")Integer teacherId,@Param("stuId")Integer stuId,String name);

    /*根据学生id，查询该学生每学年度的总分*/
    @Select("SELECT\n" +
            "course.physics+course.chinese+course.english+course.math+course.chemistry+course.biology\n" +
            "FROM\n" +
            "tb_course AS course ,\n" +
            "tb_student\n" +
            "WHERE\n" +
            "tb_student.id = course.stu_id AND\n" +
            "tb_student.id = #{stuId}")
    List<Integer> selectCourseByStuId(@Param("stuId") Integer stuId);

    /*返回教师对应学生的id，返回类型冗余，最后修改*/
    @Select("SELECT\n" +
            "tb_course.school_year,\n" +
            "tb_student.id,\n" +
            "tb_student.student_name\n" +
            "FROM\n" +
            "tb_course ,\n" +
            "tb_student\n" +
            "INNER JOIN tb_teacher ON tb_student.teacher_id = tb_teacher.id\n" +
            "WHERE\n" +
            "tb_course.stu_id = tb_student.id AND\n" +
            "tb_teacher.id = #{id}")
    List<StuCourseOfYearDTO> selectStuIdAndYearByTeacherId(@Param("id") Integer id);

    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}