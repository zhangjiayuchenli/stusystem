package com.njit.stusystem.controller;

import com.njit.stusystem.dto.*;
import com.njit.stusystem.model.Breakexercisecheck;
import com.njit.stusystem.model.Classroomcheck;
import com.njit.stusystem.model.Etiquettecheck;
import com.njit.stusystem.service.CheckService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.njit.stusystem.dto.Result.SUCCESS_CODE;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/5/8 16:42
 */
@Slf4j
@RestController
@RequestMapping("check/")
public class CheckController {

    @Autowired
    private CheckService checkService;

    // 获取本班课间操学生信息
    @GetMapping("getBreakExerciseCheck")
    public Result getBreakExerciseCheck(String year, String week, HttpSession session)
    {
        log.info(week);
        int id=(Integer)session.getAttribute("id");
        List<BreakExerciseDTO> BreakExerciseDTOList=checkService.selectByIdAndYearAndWeek(id,year,week);
        return Result.<List<BreakExerciseDTO>>builder().code(SUCCESS_CODE).res(BreakExerciseDTOList).build();
    }

    // 学生获取个人课间操学生信息
    @GetMapping("getStuBreak")
    public Result getStuBreak(String year, String week, HttpSession session)
    {
        log.info(week);
        int id=(Integer)session.getAttribute("id");
        List<BreakExerciseDTO> BreakExerciseDTOList=checkService.selectByStuIdAndYearAndWeek(id,year,week);
        return Result.<List<BreakExerciseDTO>>builder().code(SUCCESS_CODE).res(BreakExerciseDTOList).build();
    }

    // 获取本班礼仪规范学生信息
    @GetMapping("getEtiquetteCheck")
    public Result getEtiquetteDTOCheck(String year, String week, HttpSession session)
    {
        log.info(week);
        int id=(Integer)session.getAttribute("id");
        List<EtiquetteDTO> EtiquetteDTOList=checkService.selectEtiquetteDTOByIdAndYearAndWeek(id,year,week);
        return Result.<List<EtiquetteDTO>>builder().code(SUCCESS_CODE).res(EtiquetteDTOList).build();
    }

    @GetMapping("getStuEtiquette")
    public Result getStuEtiquette(String year, String week, HttpSession session)
    {
        log.info(week);
        int id=(Integer)session.getAttribute("id");
        List<EtiquetteDTO> EtiquetteDTOList=checkService.selectEtiquetteDTOByStuIdAndYearAndWeek(id,year,week);
        return Result.<List<EtiquetteDTO>>builder().code(SUCCESS_CODE).res(EtiquetteDTOList).build();
    }

    @GetMapping("getClassroomCheck")
    public Result getClassroomCheck(String year,String week,HttpSession session)
    {
        log.info(week);
        int id=(Integer)session.getAttribute("id");
        List<ClassroomDTO> classroomDTOList=checkService.selectClassroomByIdAndYearAndWeek(id,year,week);
        return Result.<List<ClassroomDTO>>builder().code(SUCCESS_CODE).res(classroomDTOList).build();
    }

    @GetMapping("getStuClass")
    public Result getStuClass(String year,String week,HttpSession session)
    {
        log.info(week);
        int id=(Integer)session.getAttribute("id");
        List<ClassroomDTO> classroomDTOList=checkService.selectClassroomByStuIdAndYearAndWeek(year,week,id);
        return Result.<List<ClassroomDTO>>builder().code(SUCCESS_CODE).res(classroomDTOList).build();
    }

    @DeleteMapping("deleteEtiquette")
    public Result deleteEtiquette(@RequestBody EtiquetteDTO etiquetteDTO,HttpSession session)
    {
        checkService.deleteEtiquette(etiquetteDTO.getId());
        int id=(Integer)session.getAttribute("id");
        String year=etiquetteDTO.getSchoolYear();
        String week=etiquetteDTO.getWeek();
        List<EtiquetteDTO> EtiquetteDTOList=checkService.selectEtiquetteDTOByIdAndYearAndWeek(id,year,week);
        return Result.<List<EtiquetteDTO>>builder().code(SUCCESS_CODE).res(EtiquetteDTOList).build();
    }

    @DeleteMapping("deleteClassroom")
    public Result deleteClassroom(@RequestBody ClassroomDTO classroomDTO,HttpSession session)
    {
        checkService.deleteClassroom(classroomDTO.getId());
        int id=(Integer)session.getAttribute("id");
        String year=classroomDTO.getSchoolYear();
        String week=classroomDTO.getWeek();
        List<ClassroomDTO> classroomDTOList=checkService.selectClassroomByIdAndYearAndWeek(id,year,week);
        return Result.<List<ClassroomDTO>>builder().code(SUCCESS_CODE).res(classroomDTOList).build();
    }

    @DeleteMapping("deleteBreakExercise")
    public Result deleteBreakExercise(@RequestBody BreakExerciseDTO breakExerciseDTO,HttpSession session)
    {
        checkService.deleteBreakExercise(breakExerciseDTO.getId());
        int id=(Integer)session.getAttribute("id");
        String year=breakExerciseDTO.getSchoolYear();
        String week=breakExerciseDTO.getWeek();
        List<BreakExerciseDTO> BreakExerciseDTOList=checkService.selectByIdAndYearAndWeek(id,year,week);
        return Result.<List<BreakExerciseDTO>>builder().code(SUCCESS_CODE).res(BreakExerciseDTOList).build();
    }

    @DeleteMapping("deleteClassroomByCheck")
    public Result deleteClassroomByCheck(@RequestBody ByCheckDTO byCheckDTO, HttpSession session)
    {
        byCheckDTO.getList().stream().forEach(t->{
            checkService.deleteClassroom(t);
        });
        int id=(Integer)session.getAttribute("id");
        String year=byCheckDTO.getYear().get(0);
        String week=byCheckDTO.getWeek().get(0);
        List<ClassroomDTO> classroomDTOList=checkService.selectClassroomByIdAndYearAndWeek(id,year,week);
        return Result.<List<ClassroomDTO>>builder().code(SUCCESS_CODE).res(classroomDTOList).build();
    }

    @DeleteMapping("deleteBreakExerciseByCheck")
    public Result deleteBreakExerciseByCheck(@RequestBody ByCheckDTO byCheckDTO, HttpSession session)
    {
        byCheckDTO.getList().stream().forEach(t->{
            checkService.deleteBreakExercise(t);
        });
        int id=(Integer)session.getAttribute("id");
        String year=byCheckDTO.getYear().get(0);
        String week=byCheckDTO.getWeek().get(0);
        List<BreakExerciseDTO> BreakExerciseDTOList=checkService.selectByIdAndYearAndWeek(id,year,week);
        return Result.<List<BreakExerciseDTO>>builder().code(SUCCESS_CODE).res(BreakExerciseDTOList).build();
    }

    @DeleteMapping("deleteEtiquetteByCheck")
    public Result deleteEtiquetteByCheck(@RequestBody ByCheckDTO byCheckDTO, HttpSession session)
    {
        byCheckDTO.getList().stream().forEach(t->{
            checkService.deleteEtiquette(t);
        });
        int id=(Integer)session.getAttribute("id");
        String year=byCheckDTO.getYear().get(0);
        String week=byCheckDTO.getWeek().get(0);
        List<EtiquetteDTO> EtiquetteDTOList=checkService.selectEtiquetteDTOByIdAndYearAndWeek(id,year,week);
        return Result.<List<EtiquetteDTO>>builder().code(SUCCESS_CODE).res(EtiquetteDTOList).build();
    }

    @PutMapping("updateClassroom")
    public Result updateClassroom(@RequestBody Classroomcheck classroomcheck,HttpSession session)
    {
        String format="yyyy-MM-nn";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = classroomcheck.getCreatTime();

        try {

            Date date = df.parse(dateString);
            System.out.println(df.format(date));
            log.info(df.format(date));
            classroomcheck.setCreatTime(df.format(date));
        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

        checkService.updateClassroom(classroomcheck);
        int id=(Integer)session.getAttribute("id");
        String year=classroomcheck.getSchoolYear();
        String week=classroomcheck.getWeek();
        List<ClassroomDTO> classroomDTOList=checkService.selectClassroomByIdAndYearAndWeek(id,year,week);
        return Result.<List<ClassroomDTO>>builder().code(SUCCESS_CODE).res(classroomDTOList).build();
    }

    @GetMapping("selectStuIdByTeacherId")
    public Result selectStuIdByTeacherId(HttpSession session)
    {
        int id=(Integer)session.getAttribute("id");
        List<StuIdDTO> list=checkService.selectStuIdByteacherID(id);
        return Result.<List<StuIdDTO>>builder().code(SUCCESS_CODE).res(list).build();
    }

    @GetMapping("getClassroomStuOfCreatetime")
    public Result getClassroomStuOfCreatetime(int studentId)
    {
        List<CreateTimeDto> list=checkService.selectClassroomTimeByStuId(studentId);
        return Result.<List<CreateTimeDto>>builder().code(SUCCESS_CODE).res(list).build();
    }

    @PostMapping("insertClassroom")
    public Result insertClassroom(@RequestBody Classroomcheck classroomcheck)
    {
        checkService.insertClassroom(classroomcheck);
        return Result.builder().code(SUCCESS_CODE).build();
    }

    @PostMapping("insertBreakExercise")
    public Result insertBreakExercise(@RequestBody Breakexercisecheck classroomcheck)
    {
        checkService.insertBreakExercise(classroomcheck);
        return Result.builder().code(SUCCESS_CODE).build();
    }

    @PutMapping("updateBreakExercise")
    public Result updateBreakExercise(@RequestBody Breakexercisecheck classroomcheck,HttpSession session)
    {
        String format="yyyy-MM-nn";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = classroomcheck.getCreateTime();

        try {

            Date date = df.parse(dateString);
            System.out.println(df.format(date));
            log.info(df.format(date));
            classroomcheck.setCreateTime(df.format(date));
        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

        checkService.updateBreakExercise(classroomcheck);
        int id=(Integer)session.getAttribute("id");
        String year=classroomcheck.getSchoolYear();
        String week=classroomcheck.getWeek();
        List<BreakExerciseDTO> breakExerciseDTOList=checkService.selectByIdAndYearAndWeek(id,year,week);
        return Result.<List<BreakExerciseDTO>>builder().code(SUCCESS_CODE).res(breakExerciseDTOList).build();
    }

    @PostMapping("insertEtiquette")
    public Result insertEtiquette(@RequestBody Etiquettecheck classroomcheck)
    {
        checkService.insertEtiquette(classroomcheck);
        return Result.builder().code(SUCCESS_CODE).build();
    }

    @PutMapping("updateEtiquette")
    public Result updateEtiquette(@RequestBody Etiquettecheck classroomcheck,HttpSession session)
    {
        String format="yyyy-MM-nn";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = classroomcheck.getCreateTime();

        try {

            Date date = df.parse(dateString);
            System.out.println(df.format(date));
            log.info(df.format(date));
            classroomcheck.setCreateTime(df.format(date));
        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
        checkService.updateEtiquette(classroomcheck);
        int id=(Integer)session.getAttribute("id");
        String year=classroomcheck.getSchoolYear();
        String week=classroomcheck.getWeek();
        List<EtiquetteDTO> etiquetteDTOList=checkService.selectEtiquetteDTOByIdAndYearAndWeek(id,year,week);
        return Result.<List<EtiquetteDTO>>builder().code(SUCCESS_CODE).res(etiquetteDTOList).build();
    }
}
