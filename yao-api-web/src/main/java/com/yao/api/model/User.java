package com.yao.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by 姚焕焕 on 2018/08/09 09:06
 * desc 用户实体类
 * qq 1107129170@qq.com
 */
public class User implements Serializable{

    @ApiModelProperty(value = "主键id",hidden = true)
    private Long id;

    @ApiModelProperty(value = "用户名",example = "admin")
    private String username;

    @JsonIgnore
    @ApiModelProperty(value = "密码",example = "123456")
    private String password;

    @JsonIgnore
    @ApiModelProperty(value = "秘钥",hidden = true)
    private String secret;

    @ApiModelProperty(value = "token",hidden = true)
    transient private String token;
    @JsonIgnore

    @ApiModelProperty(value = "创建日期",hidden = true)
    private String createdDate;

    @JsonIgnore
    @ApiModelProperty(value = "更新日期",hidden = true)
    private String updateDate;

    @JsonIgnore
    @ApiModelProperty(value = "最近登录日期",hidden = true)
    private String lastLogin;

    @JsonIgnore
    @ApiModelProperty(value = "删除标志",hidden = true)
    private String deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                '}';
    }
}
