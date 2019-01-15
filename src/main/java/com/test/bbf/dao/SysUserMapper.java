package com.test.bbf.dao;

import com.test.bbf.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    List<SysUser> getUserList();
    SysUser getUserByName(@Param("loginname") String loginname);
}
