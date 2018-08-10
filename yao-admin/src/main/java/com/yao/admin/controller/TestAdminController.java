package com.yao.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 姚焕焕 on 2018/08/09 09:06
 * desc
 * qq 1107129170@qq.com
 */

@Api(value = "value", description = "description")
@Controller
public class TestAdminController {

    @ApiOperation(value = "我是value", notes = "notes [@姚焕焕]")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public Map test(){

//        userMapper.insert(new User());
//        System.out.println(user.toString());
        return new HashMap();
    }
}
