package com.yao.api.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 姚焕焕 on 2018/11/13 11:49
 * desc token相关工具
 * qq 1107129170@qq.com
 */
public class JWTUtil {

    /**
     * @param token 需要解密的token
     * @param secret 解密秘钥
     * @return DecodedJWT 如果返回null说明解密失败，需要处理（还需要验证健壮性）
     */
    public static DecodedJWT deToken(final String token, String secret) {
        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            jwt = verifier.verify(token);
        }catch (Exception e) {
            return null;
        }
        return jwt;
    }

    /**
     *
     * @param map 存放需要用到的参数
     * @param secret 解密的秘钥
     * @return String 返回token，如果返回null说明解密失败，需要处理（还需要验证健壮性）
     */
    public static String getToken(Map<String, String> map, String secret) {

        Date expiresAt = new Date(System.currentTimeMillis() + 48L * 60L * 60L * 1000L);
        String token = null;
        try {
            JWTCreator.Builder builder = JWT.create()
                    //签发者
                    .withIssuer("server")
                    //过期时间
                    .withExpiresAt(expiresAt);
            for (String s : map.keySet()){
                builder = builder.withClaim(s,map.get(s));
            }

            token = builder.sign(Algorithm.HMAC256(secret));

        } catch (Exception e) {
            return null;
        }

        return token;
    }

    public static void main(String[] args) {

//        Map<String,String> map = new HashMap<>();
//        map.put("user_id","12");
//        String token = getToken(map,"ABC111");
//        System.out.println("token: " + token);
//
//        // 解密token
//
//        DecodedJWT jwt = deToken("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMTIiLCJpc3MiOiJzZXJ2ZXIiLCJleHAiOjE1NDIxODM5Mjh9.9dTx2Lqma8lpkWvTA0G_jJ2yi66vOss174g799EVCfA","ABC111");
//        if (jwt != null){
//            System.out.println("user_id:     " + jwt.getClaim("user_id").asString());
//            System.out.println("getIssuer:     " + jwt.getIssuer());
//            System.out.println("过期时间：      " + jwt.getExpiresAt().getTime());
//        }else {
//            System.out.println("验证不通过");
//        }
        System.out.println(UUID.randomUUID().toString().replace("-","").length());

    }

}
