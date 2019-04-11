package com.njit.stusystem.mapper;

import com.njit.stusystem.dto.AdminDTO;
import com.njit.stusystem.model.Admin;
import com.njit.stusystem.model.AdminExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    /*登录验证用户名和密码，用户名为主键id*/
    @Select("select * from tb_admin where id=#{id} and password=#{password}")
    AdminDTO selectByUsernameAndPassword(@Param("id")Integer id, @Param("password")String password);

    @Select("select * from tb_admin")
    List<Admin> selectAll();

    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}