package com.yao.api.common;

/**
 * Created by 姚焕焕 on 2018/11/05 14:19
 * desc 返回状态码
 * qq 1107129170@qq.com
 */
public enum ResponseCode {

    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    NEED_LOGIN(10,"认证未通过，请重新登录"),
    ILLEGAL_ARGUMENT(2,"参数错误");

    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
