package com.yao.api.service.impl;


import com.yao.api.dao.UserMapper;
import com.yao.api.model.User;
import com.yao.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 姚焕焕 on 2018/11/06 11:23
 * desc
 * qq 1107129170@qq.com
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User register() {
        System.out.println("123");
        return userMapper.selectAll().get(0);
    }
}
