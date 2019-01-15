package com.test.bbf.service.impl;

import com.test.bbf.dao.SysUserMapper;
import com.test.bbf.entity.SysUser;
import com.test.bbf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getUserList() {
        return sysUserMapper.getUserList();
    }

    @Override
    public SysUser getUserByName(String loginname) {
        return sysUserMapper.getUserByName(loginname);
    }
}
