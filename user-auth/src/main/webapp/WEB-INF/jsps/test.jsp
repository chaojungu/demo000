<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/29
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页面</title>
</head>
<body>
    count: ${count}
    <br>
    request数据： ${requestScope.requestValue}
    <br>
    session数据： ${sessionScope.sessionValue}
</body>
</html>
