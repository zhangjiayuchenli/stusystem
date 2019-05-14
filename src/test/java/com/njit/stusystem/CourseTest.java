package com.njit.stusystem;

import com.njit.stusystem.dto.CourseDTO;
import com.njit.stusystem.dto.StuAndCourseDTO;
import com.njit.stusystem.mapper.BreakexercisecheckMapper;
import com.njit.stusystem.mapper.ClassroomcheckMapper;
import com.njit.stusystem.mapper.CourseMapper;
import com.njit.stusystem.mapper.EtiquettecheckMapper;
import com.njit.stusystem.model.Breakexercisecheck;
import com.njit.stusystem.model.Classroomcheck;
import com.njit.stusystem.model.Course;
import com.njit.stusystem.model.Etiquettecheck;
import com.njit.stusystem.service.CheckService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseTest extends BaseTest {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private BreakexercisecheckMapper breakexercisecheckMapper;

    @Autowired
    private EtiquettecheckMapper etiquettecheckMapper;

    @Autowired
    private ClassroomcheckMapper classroomcheckMapper;

    @Autowired
    private CheckService checkService;

    @Test
    public void testSelectCourseByYears()
    {
        System.out.println(checkService.selectClassroomTimeByStuId(202151336));
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
    @Test
    public void testInsertCheck()
    {
        int i=202151336;
        Breakexercisecheck b=new Breakexercisecheck();
        while (i<202151360)
        {
            b.setStuId(i);
            b.setSchoolYear("第一学期");
            b.setWeek("第二周");
            b.setCreateTime("2019-05-15");
            b.setActionStandard(5);
            b.setEyeExercises(10);
            b.setQueueNeat(9);
            b.setLater(10);
            b.setPreExercises(8);
            breakexercisecheckMapper.insertSelective(b);
            i++;
        }


    }

    @Test
    public void testInsertCheck2()
    {
        int i=202151336;
        Etiquettecheck b=new Etiquettecheck();
        while (i<202151360)
        {
            b.setStuId(i);
            b.setSchoolYear("第一学期");
            b.setWeek("第一周");
            b.setCreateTime("2019-05-08").
                    setCivilized(10).
                    setFlag(10).
                    setHealth(8).
                    setKeepRules(7).
                    setRespect(10);
            etiquettecheckMapper.insertSelective(b);
            i++;
        }


    }

    @Test
    public void testInsertCheck3()
    {
        int i=202151337;
        Classroomcheck c=new Classroomcheck();
        while (i<202151360)
        {
            c.setStuId(i);
            c.setSchoolYear("第一学期");
            c.setWeek("第一周");
            c.setCreatTime("2019-05-08");
            c.setDiscussionDegree(10);
            c.setHelpClassmates(9);
            c.setLater(10);
            c.setPositiveDegree(10);
            c.setWork(9);
            classroomcheckMapper.insertSelective(c);
            i++;
        }


    }
}
