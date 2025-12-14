package com.chatroom.servlet;

import com.chatroom.model.User;  // 确保这行存在

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("UTF-8");
        // 设置响应编码
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        if (username == null || username.trim().isEmpty()) {
            resp.sendRedirect("login.jsp");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", new User(username));

        // 将用户添加到在线用户列表
        ServletContext context = getServletContext();
        List<User> onlineUsers = (List<User>) context.getAttribute("onlineUsers");  // 添加类型转换
        if (onlineUsers == null) {
            onlineUsers = new ArrayList<>();
            context.setAttribute("onlineUsers", onlineUsers);
        }
        onlineUsers.add(new User(username));

        resp.sendRedirect("chat.jsp");
    }
}