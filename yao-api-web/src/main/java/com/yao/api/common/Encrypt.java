package com.yao.api.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 姚焕焕 on 2018/11/08 10:16
 * desc 解密
 * qq 1107129170@qq.com
 */
public class Encrypt {

    /**
     *
     * @param map 存放需要用到的参数
     * @param secret 解密的秘钥
     * @return
     */
    public String getToken(Map<String, String> map,String secret) {

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
            e.printStackTrace();
        }

        return token;
    }

    public static void main(String[] args) {
        Encrypt encrypt = new Encrypt();
        Map<String,String> map = new HashMap<>();
        map.put("user_id","12");
        String token = encrypt.getToken(map,"ABC111");
        System.out.println("token: " + token);
        Decrypt decrypt = new Decrypt();
        // 解密token

        DecodedJWT jwt = decrypt.deToken("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMTIiLCJpc3MiOiJzZXJ2ZXIiLCJleHAiOjE1NDIxODM5Mjh9.9dTx2Lqma8lpkWvTA0G_jJ2yi66vOss174g799EVCfA","ABC111");
        if (jwt != null){
            System.out.println("user_id:     " + jwt.getClaim("user_id").asString());
            System.out.println("getIssuer:     " + jwt.getIssuer());
            System.out.println("过期时间：      " + jwt.getExpiresAt().getTime());
        }else {
            System.out.println("验证不通过");
        }

    }
}
