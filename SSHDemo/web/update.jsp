<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: TONG
  Date: 2017/8/3
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<center>
    <s:form action="updateUser" method="POST">
        <tr>
            <td colspan="2" align="center">
                <h1><s:text name="update userinfo"/></h1><br/>
                <s:actionerror/>
            </td>
        </tr>
        <s:label name="user.id" key="ID"
                     value="%{#parameters.id}" required="true"></s:label>
        <s:textfield name="user.name" key="用户名"
                     tooltip="Enter your name" required="true"></s:textfield>
        <s:textfield name="user.password" key="密码"
                     tooltip="Enter password" required="true"></s:textfield>
        <s:textfield name="user.type" key="类型"
                     tooltip="Enter your type" required="true"></s:textfield>
        <s:submit value="提交"/>
        <s:reset value="重置"/>
        <s:set/>
    </s:form>
</center>
</body>
</html>
