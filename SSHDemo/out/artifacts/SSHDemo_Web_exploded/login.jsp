<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: TONG
  Date: 2017/7/24
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <s:form action="login" method="post">
        <s:textfield name="username" label="用户名"/>
        <s:password name="password" label="密码"/>
        <s:textfield name="usertype" label="类型"/>
        <s:submit value="submit"/>
    </s:form>
    <a href="userQuery.action">all</a>
</body>
</html>
