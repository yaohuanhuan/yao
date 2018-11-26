package com.yao.api.controller;

import com.yao.api.common.ServerResponse;
import com.yao.api.model.User;
import com.yao.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 姚焕焕 on 2018/11/07 09:08
 * desc
 * qq 1107129170@qq.com
 */

@Api(value = "用户Controller", description = "用户Controller [@姚焕焕]")
@RequestMapping(value = "api/user/")
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册",notes = "用户注册 [@姚焕焕]")
    @ResponseBody
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ServerResponse<User> register(@RequestBody User user){
        return userService.register(user);
    }

    @ApiOperation(value = "用户登录",notes = "用户登录 [@姚焕焕]")
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ServerResponse<User> login(@RequestBody User user){
        return userService.login(user);
    }

    @ApiOperation(value = "用户登录",notes = "用户登录 [@姚焕焕]")
    @ResponseBody
    @RequestMapping(value = "login2",method = RequestMethod.POST)
    public ServerResponse<User> login2(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.login(user);
    }

}
