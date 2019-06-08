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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" >
</head>
<body>

<form action="${pageContext.request.contextPath}/file/doupload" method="post"
      enctype="multipart/form-data">
    <table>
        <tr>
            <td>上传人</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr><tr>
        <td>文件</td>
        <td>
            <input type="file" name="pic">
        </td>
    </tr><tr>
        <td></td>
        <td>
            <input type="submit" name="send" value="上传">
        </td>
    </tr>
    </table>
</form>

</body>
</html>
