package com.yao.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaohuanhuan on 2018/8/7 0007.
 */
@Controller
public class TestApiController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public Map test(){
        Map map = new HashMap();
        map.put("name","zhangsan");
        map.put("age",18);
        return map;
    }
}
