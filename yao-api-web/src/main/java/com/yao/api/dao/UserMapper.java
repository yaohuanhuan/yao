package com.yao.api.dao;

import com.yao.api.model.User;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * Created by 姚焕焕 on 2018/08/09 09:41
 * desc
 * qq 1107129170@qq.com
 */
public interface UserMapper extends Mapper<User> {

    List<User> selectAllUser();

}
