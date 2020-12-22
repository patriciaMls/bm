package com.zlt.controller;

import com.alibaba.fastjson.JSON;
import com.zlt.common.ResultCode;
import com.zlt.entity.User;
import com.zlt.service.UserService;
import com.zlt.service.impl.UserServiceImpl;
import org.apache.shiro.crypto.hash.Md5Hash;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/11/4 21:05
 * @version: 1.0
 * @modified By:
 */

/**
 * WebServlet服务器程序地址配置 - url地址
 * @WebServlet("/login") - http://localhost:8080/bm/login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserService us = new UserServiceImpl() ;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); // 设置编码问题
        System.out.println("=====用户在请求服务器代码====");

        String data = req.getParameter("data");
        System.out.println(data);

        // 进行参数分隔
        String[] params = data.split("&");

        // 进行身份认证：通过用户手机号来进行数据校验
        String telphone = URLDecoder.decode(params[0].split("=")[1], "utf-8");
        String password = URLDecoder.decode(params[1].split("=")[1], "utf-8");

        Md5Hash md5Hash = new Md5Hash(password); // md5的加密类 - shiro 权限框架
        password = md5Hash.toHex(); // 加密后密文
        User user = us.getUser(telphone);

        System.out.println(user.toString());

        if (password.equals(user.getPassword())){
            System.out.println(" ==== 用户身份匹配成功  ====  ");
            // 完成页面的跳转 - 根据前端采用技术来处理页面跳转
            // 如果前端采用ajax技术，则我们后端只能通过json数据进行业务的响应
            ResultCode<User> resultCode = new ResultCode<>(200, "success",user);

            // response 接口 - 服务器响应接口
            // 1. 定义数据响应格式
            // 2. 定义输出流
            // 3. 将java对象转换为json
            // 4. 输出json数据
            resp.setContentType("text/plain;charset=utf-8");
            PrintWriter out = resp.getWriter();
            String json = JSON.toJSONString(resultCode);
            out.println(json);
            out.close();
        }else {
            System.out.println(" ==== 用户身份匹配不成功  ====  ");
            ResultCode resultCode = new ResultCode(400,"fail");
        }
    }
}
