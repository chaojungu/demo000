<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/28
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr><tr>
            <td>密码</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr><tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="登录">
            </td>
        </tr>
    </table>
</form>

<h2>使用lgin2处理登录请求，用对象接收参数信息</h2>
<div>${errorMsg}</div>
<form action="${pageContext.request.contextPath}/login2">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="usernameo" value="${user.username}">
            </td>
        </tr><tr>
        <td>密码</td>
        <td>
            <input type="password" name="password" value="${user.password}">
        </td>
    </tr><tr>
        <td></td>
        <td>
            <input type="submit" name="submit" value="登录">
        </td>
    </tr>
    </table>
</form>

<h2>使用login3处理登录请求，用对象接收参数信息,使用Model传递数据到视图</h2>
<div>${errorMsg}</div>
<form action="${pageContext.request.contextPath}/login3">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username" value="${user.username}">
            </td>
        </tr><tr>
        <td>密码</td>
        <td>
            <input type="password" name="password" value="${user.password}">
        </td>
    </tr><tr>
        <td></td>
        <td>
            <input type="submit" name="submit" value="登录">
        </td>
    </tr>
    </table>
</form>

<h2>使用login4处理登录请求，用对象接收参数信息,使用Map传递数据到视图</h2>
<div>${errorMsg}</div>
<form action="${pageContext.request.contextPath}/login4">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username" value="${user.username}">
            </td>
        </tr><tr>
        <td>密码</td>
        <td>
            <input type="password" name="password" value="${user.password}">
        </td>
    </tr><tr>
        <td></td>
        <td>
            <input type="submit" name="submit" value="登录">
        </td>
    </tr>
    </table>
</form>
</body>
</html>
