package com.njit.stusystem;

import com.njit.stusystem.dto.CourseDTO;
import com.njit.stusystem.dto.StuAndCourseDTO;
import com.njit.stusystem.mapper.CourseMapper;
import com.njit.stusystem.model.Course;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseTest extends BaseTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void testSelectCourseByYears()
    {
        //System.out.println(courseMapper.selectCourseByYear(1));
    }

    @Test
    public void test()
    {
        System.out.println(courseMapper.selectStuIdAndYearByTeacherId(6));
    }
    @Test
    public void testInsert()
    {
        int i=202151367;
        Course course=new Course();
        while (i<202151372)
        {
            course.setBiology(90);
            course.setChemistry(90);
            course.setChinese(130);
            course.setEnglish(130);
            course.setMath(130);
            course.setPhysics(90);
            course.setSchoolYear(1);
            course.setStuId(i);
            courseMapper.insertSelective(course);
            i++;

        }
    }
}
