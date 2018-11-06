package com.yao.api.Service;

import com.yao.api.common.ServerResponse;
import com.yao.api.model.User;

/**
 * Created by 姚焕焕 on 2018/11/05 16:05
 * desc
 * qq 1107129170@qq.com
 */
public interface UserService {

    ServerResponse<User> register(User user);

}
