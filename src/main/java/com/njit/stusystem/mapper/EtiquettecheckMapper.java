package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.EtiquetteDTO;
import com.njit.stusystem.model.Etiquettecheck;
import com.njit.stusystem.model.EtiquettecheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EtiquettecheckMapper {

    @Select("SELECT\n" +
            "stu.student_name,\n" +
            "e.id,\n" +
            "e.school_year,\n" +
            "e.`week`,\n" +
            "e.create_time,\n" +
            "e.stu_id,\n" +
            "e.respect,\n" +
            "e.keep_rules,\n" +
            "e.civilized,\n" +
            "e.health,\n" +
            "e.flag\n" +
            "FROM\n" +
            "tb_student AS stu ,\n" +
            "tb_etiquettecheck AS e\n" +
            "WHERE\n" +
            "stu.teacher_id = #{id} AND\n" +
            "e.stu_id = stu.id AND\n" +
            "e.school_year = #{year} AND\n" +
            "e.`week` = #{week}")
    List<EtiquetteDTO> selectByIdAndYearAndWeek(@Param("id") int id, @Param("week") String week, @Param("year") String year);

    @Select("SELECT\n" +
            "e.id,\n" +
            "e.school_year,\n" +
            "e.`week`,\n" +
            "e.create_time,\n" +
            "e.stu_id,\n" +
            "e.respect,\n" +
            "e.keep_rules,\n" +
            "e.civilized,\n" +
            "e.health,\n" +
            "e.flag,\n" +
            "stu.student_name\n" +
            "FROM\n" +
            "tb_etiquettecheck AS e ,\n" +
            "tb_student AS stu\n" +
            "WHERE\n" +
            "stu.id = e.stu_id AND\n" +
            "e.stu_id = #{id} AND\n" +
            "e.school_year = #{year} AND\n" +
            "e.`week` = #{week}\n")
    List<EtiquetteDTO> selectByStuIdAndYearAndWeek(@Param("id") int id,  @Param("year") String year,@Param("week") String week);

    long countByExample(EtiquettecheckExample example);

    int deleteByExample(EtiquettecheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Etiquettecheck record);

    int insertSelective(Etiquettecheck record);

    List<Etiquettecheck> selectByExample(EtiquettecheckExample example);

    Etiquettecheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Etiquettecheck record, @Param("example") EtiquettecheckExample example);

    int updateByExample(@Param("record") Etiquettecheck record, @Param("example") EtiquettecheckExample example);

    int updateByPrimaryKeySelective(Etiquettecheck record);

    int updateByPrimaryKey(Etiquettecheck record);
}