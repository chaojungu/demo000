<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/29
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/email/saveorsend" method="post">
    <table>
        <tr>
            <td>收件人</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr><tr>
        <td>邮件内容</td>
        <td>
           <textarea name="content"></textarea>
        </td>
    </tr><tr>
        <td></td>
        <td>
            <input type="submit" name="save" value="存草稿">
            <input type="submit" name="send" value="发送">
            <input type="button" name="cancel" value="取消">
        </td>
    </tr>
    </table>
</form>

</body>
</html>
