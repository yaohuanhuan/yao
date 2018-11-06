package com.yao.admin.serviceImpl;


import com.yao.admin.dao.UserMapper;
import com.yao.admin.model.User;
import com.yao.admin.service.UserService;
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
        return userMapper.selectAllUser().get(0);
    }
}
