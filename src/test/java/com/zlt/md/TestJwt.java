package com.zlt.md;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.Calendar;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/2 22:53
 * @version: 1.0
 * @modified By:
 */

public class TestJwt {
    // 密钥
    private static String secret = "F@#@#^FSFAH%@!$@";

    // 生成token令牌
    @Test
    public void createToken(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 120);// 当前系统时间+120秒
        String token = JWT.create()
                .withClaim("idcard", "511381199806011718")
                .withClaim("telphone", "17398893791")
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(secret));
        System.out.println(token);
    }

    @Test
    public void verify(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build(); // 令牌校验器
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZGNhcmQiOiI1MTEzODExOTk4MDYwMTE3MTgiLCJ0ZWxwaG9uZSI6IjE3Mzk4ODkzNzkxIiwiZXhwIjoxNjA2OTIyMDM4fQ.-U-qBUxS4tbqCMGCJ_xQsfOl7QkgWb7WRnC8s4heNWk";
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        System.out.println("身份证："+decodedJWT.getClaim("idcard").asString()); // 存储string --> 用asString取出
        System.out.println("手机号："+decodedJWT.getClaim("telphone").asString()); // 存储string --> 用asString取出
        System.out.println("过期时间："+decodedJWT.getExpiresAt());
    }
}
