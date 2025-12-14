package com.chatroom.servlet;

import com.chatroom.model.Message;
import com.chatroom.model.User;  // 添加这行import

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("UTF-8");
        // 设置响应编码
        resp.setContentType("text/html;charset=UTF-8");

        String content = req.getParameter("message");
        User user = (User) req.getSession().getAttribute("user");
        String username = user != null ? user.getUsername() : "匿名用户";  // 修复方法名

        if (content != null && !content.trim().isEmpty()) {
            ServletContext context = getServletContext();
            List<Message> messages = (List<Message>) context.getAttribute("messages");  // 添加类型转换
            if (messages == null) {
                messages = new ArrayList<>();
                context.setAttribute("messages", messages);
            }
            messages.add(new Message(username, content));
        }

        resp.sendRedirect("chat.jsp");
    }
}