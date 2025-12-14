<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.chatroom.model.Message, com.chatroom.model.User, java.util.List" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>聊天室</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="chat-container">
    <header>
        <h2>在线聊天室</h2>
        <div>欢迎：<%= user.getUsername() %> | <a href="logout">退出</a></div>
    </header>
    <div class="chat-content">
        <div class="messages">
            <%
                ServletContext context = application;
                List<Message> messages = (List<Message>) context.getAttribute("messages");
                if (messages != null) {
                    for (Message msg : messages) {
            %>
            <p><strong><%= msg.getUsername() %>:</strong> <%= msg.getContent() %></p>
            <%
                    }
                }
            %>
        </div>
        <div class="online-users">
            <h4>在线用户</h4>
            <ul>
                <%
                    List<User> onlineUsers = (List<User>) context.getAttribute("onlineUsers");
                    if (onlineUsers != null) {
                        for (User u : onlineUsers) {
                %>
                <li><%= u.getUsername() %></li>
                <%
                        }
                    }
                %>
            </ul>
        </div>
    </div>
    <footer>
        <form action="chat" method="post">
            <input type="text" name="message" placeholder="输入消息..." required>
            <button type="submit">发送</button>
        </form>
    </footer>
</div>
</body>
</html>