package com.yao.api.service;


import com.yao.api.common.ServerResponse;
import com.yao.api.model.User;

/**
 * Created by 姚焕焕 on 2018/11/06 11:22
 * desc
 * qq 1107129170@qq.com
 */
public interface UserService {


    ServerResponse<User> register(User user);

    ServerResponse<User> login(User user);

}
