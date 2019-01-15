package com.test.bbf.service.impl;

import com.test.bbf.dao.UserPowerMapper;
import com.test.bbf.entity.UserPower;
import com.test.bbf.service.UserPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserPowerService")
public class UserPowerServiceImpl implements UserPowerService {
    @Autowired
    private UserPowerMapper userPowerMapper;

    @Override
    public UserPower getPowerByName(String loginname) {
        return userPowerMapper.getPowerByName(loginname);
    }
}
