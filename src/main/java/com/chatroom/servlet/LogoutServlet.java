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
import java.util.List;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应编码
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            // 从在线用户列表中移除
            ServletContext context = getServletContext();
            List<User> onlineUsers = (List<User>) context.getAttribute("onlineUsers");  // 添加类型转换
            if (onlineUsers != null) {
                onlineUsers.removeIf(u -> u.getUsername().equals(user.getUsername()));
            }
            session.invalidate();
        }

        resp.sendRedirect("login.jsp");
    }
}