package com.yao.api.controller;

import com.yao.api.Service.UserService;

import com.yao.api.common.ServerResponse;
import com.yao.api.dao.UserMapper;

import com.yao.api.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by 姚焕焕 on 2018/11/05 14:19
 * desc 用户Controller
 * qq 1107129170@qq.com
 */

@Api(description = "用户Controller",authorizations = @Authorization(""))
@Controller
@RequestMapping(value = "api/user/")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @ApiOperation(value = "用户注册", notes = "用户注册 [@姚焕焕]")
    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<User>> register(){

        return ServerResponse.createBySuccess(userMapper.selectAllUser());
    }

}
