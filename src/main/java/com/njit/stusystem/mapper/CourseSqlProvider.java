package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.StuAndCourseDTO;
import org.apache.ibatis.jdbc.SQL;

public class CourseSqlProvider {

    public String selectCourseByYear(final Integer teacherId,final Integer stuId,final String name)
    {
        return new SQL(){{
            SELECT("course.physics+course.chinese+course.english+" +
                    "course.math +course.chemistry+course.biology");
            FROM("tb_course AS course , tb_student ");
            INNER_JOIN("tb_teacher ON tb_student.teacher_id = tb_teacher.id");
            WHERE("tb_teacher.id = #{teacherId}");
            WHERE("course.stu_id = tb_student.id");
            if(stuId!=null)
            {
                WHERE("tb_student.id=#{stuId}");
            }
            if(name!=null)
            {
                WHERE("tb_student.student_name=#{name}");
            }
        }}.toString();
    }
}
