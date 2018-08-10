package com.yao.api.controller;

import com.yao.api.dao.UserMapper;
import com.yao.api.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 姚焕焕 on 2018/08/09 09:06
 * desc
 * qq 1107129170@qq.com
 */

@Api(value = "value", description = "description")
@Controller
public class TestApiController {

    @Autowired
    UserMapper userMapper;

    @ApiOperation(value = "我是value", notes = "notes [@姚焕焕]")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public User test(@ModelAttribute User user){

//        userMapper.insert(new User());
        System.out.println(user.toString());
        return new User();
    }
}
