package com.yao.api.ServiceImpl;

import com.yao.api.Service.UserService;
import com.yao.api.common.ServerResponse;
import com.yao.api.dao.UserMapper;
import com.yao.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 姚焕焕 on 2018/11/05 16:09
 * desc
 * qq 1107129170@qq.com
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> register(User user) {
        userMapper.insert(user);
        return ServerResponse.createBySuccessMessage("注册成功");
    }
}
