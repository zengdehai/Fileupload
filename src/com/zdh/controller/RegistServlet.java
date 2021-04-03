package com.zdh.controller;

import com.zdh.pojo.User;
import com.zdh.service.UserService;
import com.zdh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //验证验证码
        if ("abcde".equalsIgnoreCase(code)) {
            //验证用户名
            if (service.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                //可用，就调用service中方法存到数据库中
                service.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }

        } else {
            System.out.println("验证码["+code+"]错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }
    }
}
