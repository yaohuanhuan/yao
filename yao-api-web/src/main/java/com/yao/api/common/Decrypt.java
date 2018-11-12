package com.yao.api.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

/**
 * Created by 姚焕焕 on 2018/11/08 10:20
 * desc 加密
 * qq 1107129170@qq.com
 */
public class Decrypt {

    /**
     *
     * @param token 需要解密的token
     * @param secret 解密秘钥
     * @return
     */
    public DecodedJWT deToken(final String token,String secret) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            jwt = verifier.verify(token);
        }catch (Exception e) {
        }
        return jwt;
    }
}
