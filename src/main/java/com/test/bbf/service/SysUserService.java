package com.test.bbf.service;

import com.test.bbf.entity.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> getUserList();
    SysUser getUserByName(String loginname);
}
