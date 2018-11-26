package com.yao.api.service.impl;


import com.yao.api.common.JWTUtil;
import com.yao.api.common.MD5Util;
import com.yao.api.common.ServerResponse;
import com.yao.api.dao.UserMapper;
import com.yao.api.model.User;
import com.yao.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 姚焕焕 on 2018/11/06 11:23
 * desc
 * qq 1107129170@qq.com
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param user
     * @return
     */

    @Override
    public ServerResponse<User> register(User user) {

        try {
            String username = user.getUsername();
            String password = user.getPassword();
            //判断用户名
            if (username == null || username.length() == 0) {
                return ServerResponse.createByErrorMessage("用户名不能为空");
            }
            //判断密码
            if (password == null || password.length() == 0) {
                return ServerResponse.createByErrorMessage("密码不能为空");
            }
            //判断用户是否存在
            User tempUser = new User();
            tempUser.setUsername(username);
            int userCount = userMapper.selectCount(tempUser);
            if (userCount > 0) {
                return ServerResponse.createByErrorMessage("用户已存在");
            }
            //完善用户各个属性
            user.setPassword(MD5Util.getMD5(password));
            user.setCreatedDate(String.valueOf(Calendar.getInstance().getTimeInMillis()));
            user.setUpdateDate(String.valueOf(Calendar.getInstance().getTimeInMillis()));
            int count = userMapper.register(user);
            if (count != 0) {
                return ServerResponse.createBySuccessMessage("注册成功");
            } else {
                return ServerResponse.createBySuccessMessage("注册失败");
            }
        } catch (Exception e) {
            return ServerResponse.createBySuccessMessage("注册失败:" + e.getCause().getMessage());
        }

    }

    /**
     * 用户登录
     * @param user
     * @return
     */

    @Override
    public ServerResponse<User> login(User user) {
        try {
            String username = user.getUsername();
            String password = user.getPassword();
            //判断用户名
            if (username == null || username.length() == 0) {
                return ServerResponse.createByErrorMessage("用户名不能为空");
            }
            //判断密码
            if (password == null || username.length() == 0) {
                return ServerResponse.createByErrorMessage("密码不能为空");
            }

            User tempUser = new User();
            tempUser.setUsername(username);

            List<User> userList = userMapper.select(tempUser);
            //判断用户是否存在
            if (userList.isEmpty()) {
                return ServerResponse.createByErrorMessage("用户不存在");
            } else {
                tempUser.setPassword(MD5Util.getMD5(password));
                List<User> list = userMapper.select(tempUser);
                //判断用户密码是否正确
                if (list.isEmpty()){
                    return ServerResponse.createByErrorMessage("用户名或密码错误");
                }else {
                    //生成秘钥
                    String secret = UUID.randomUUID().toString().replace("-","");
                    tempUser = list.get(0);
                    tempUser.setSecret(secret);
                    userMapper.updateByPrimaryKey(tempUser);
                    Map<String,String> map = new HashMap<>();
                    map.put("user_id", String.valueOf(tempUser.getId()));
                    tempUser.setToken(JWTUtil.getToken(map,secret));
                    tempUser.setPassword(null);
                    tempUser.setSecret(null);
                    return ServerResponse.createBySuccess("登录成功",tempUser);
                }
            }
        }catch (Exception e){
            return ServerResponse.createBySuccessMessage("登录失败:" + e.getCause().getMessage());
        }
    }
}
