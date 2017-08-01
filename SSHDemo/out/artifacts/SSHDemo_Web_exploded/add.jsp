<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: TONG
  Date: 2017/8/1
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
</head>
<body>
<center>
    <s:form action="addUser" method="POST">
        <tr>
            <td colspan="2" align="center">
                <h1><s:text name="add user"/></h1><br/>
                <s:property value="exception.message"/>
            </td>
        </tr>
        <s:textfield name="user.name" key="用户名"
                     tooltip="Enter name" required="true"></s:textfield>
        <s:textfield name="user.id" key="ID"
                     tooltip="Enter your id" required="true"></s:textfield>
        <s:textfield name="user.password" key="密码"
                    tooltip="Enter password" required="true"></s:textfield>
        <s:textfield name="user.type" key="类型"
                      tooltip="Enter your type" required="true"></s:textfield>
        <s:submit value="submit"/>
        <s:set/>
    </s:form>
</center>
</body>
</html>
