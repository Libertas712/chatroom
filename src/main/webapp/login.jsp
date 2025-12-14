<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>聊天室登录</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="login-container">
    <h2>欢迎来到聊天室</h2>
    <form action="login" method="post">
        <input type="text" name="username" placeholder="请输入用户名" required>
        <button type="submit">进入聊天室</button>
    </form>
</div>
</body>
</html>