package com.zdh.controller;

import com.zdh.pojo.User;
import com.zdh.service.UserService;
import com.zdh.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password  = request.getParameter("password");
        User user = service.login(new User(null, username, password, null));
        if (user == null){
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        } else {
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }
    }
}
