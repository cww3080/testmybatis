package com.test.bbf.dao;

import com.test.bbf.entity.UserPower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserPowerMapper {
    UserPower getPowerByName(@Param("loginname") String loginname);
}
