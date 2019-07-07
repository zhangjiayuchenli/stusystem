package com.njit.stusystem.service;

import com.njit.stusystem.dto.*;
import com.njit.stusystem.mapper.BreakexercisecheckMapper;
import com.njit.stusystem.mapper.ClassroomcheckMapper;
import com.njit.stusystem.mapper.EtiquettecheckMapper;
import com.njit.stusystem.mapper.StudentMapper;
import com.njit.stusystem.model.Breakexercisecheck;
import com.njit.stusystem.model.Classroomcheck;
import com.njit.stusystem.model.Etiquettecheck;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/5/8 16:27
 */
@Service
public class CheckService {
    @Autowired
    private BreakexercisecheckMapper b;

    @Autowired
    private EtiquettecheckMapper e;

    @Autowired
    private ClassroomcheckMapper c;

    @Autowired
    private StudentMapper s;

    public List<StuIdDTO> selectStuIdByteacherID(int id)
    {
        return s.selectStuIdByteacherID(id);
    }

    public List<CreateTimeDto> selectClassroomTimeByStuId(int id)
    {
        return c.selectClassroomTimeByStuId(id);
    }

    public int insertClassroom(Classroomcheck record)
    {
        return c.insertSelective(record);
    }

    public int insertEtiquette(Etiquettecheck record)
    {
        return e.insertSelective(record);
    }

    public int insertBreakExercise(Breakexercisecheck record)
    {
        return b.insertSelective(record);
    }

    //通过教师id
    public List<BreakExerciseDTO> selectByIdAndYearAndWeek( int id,String year,String week )
    {
        return b.selectByIdAndYearAndWeek(id,week,year);
    }
    //通过学生id
    public List<BreakExerciseDTO> selectByStuIdAndYearAndWeek( int id,String year,String week )
    {
        return b.selectByStuIdAndYearAndWeek(id,year,week);
    }

    public List<EtiquetteDTO> selectEtiquetteDTOByIdAndYearAndWeek(int id, String year, String week )
    {
        return e.selectByIdAndYearAndWeek(id,week,year);
    }

    public List<EtiquetteDTO> selectEtiquetteDTOByStuIdAndYearAndWeek(int id, String year, String week )
    {
        return e.selectByStuIdAndYearAndWeek(id,year,week);
    }

    // 查询本班学生的课堂情况
    public List<ClassroomDTO> selectClassroomByIdAndYearAndWeek(int id, String year, String week)
    {
        return c.selectByIdAndYearAndWeek(id,week,year);
    }

    // 查询本班学生的课堂情况
    public List<ClassroomDTO> selectClassroomByStuIdAndYearAndWeek( String year, String week,int id)
    {
        return c.selectByStuIdAndYearAndWeek(year,week,id);
    }

    public int deleteEtiquette(int id)
    {
       return e.deleteByPrimaryKey(id);
    }

    public int deleteBreakExercise(int id)
    {
        return b.deleteByPrimaryKey(id);
    }

    public int deleteClassroom(int id)
    {
        return c.deleteByPrimaryKey(id);
    }

    public int updateClassroom(Classroomcheck record)
    {
        return c.updateByPrimaryKeySelective(record);
    }
    public int updateEtiquette(Etiquettecheck record)
    {
        return e.updateByPrimaryKeySelective(record);
    }
    public int updateBreakExercise(Breakexercisecheck record)
    {
        return b.updateByPrimaryKeySelective(record);
    }
}
