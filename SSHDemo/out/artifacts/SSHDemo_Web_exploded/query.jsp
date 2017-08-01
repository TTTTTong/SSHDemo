<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: TONG
  Date: 2017/7/31
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllUser</title>
</head>
<body>
<center>
    <h1>all user</h1>
    <table border="1" width="400">
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>用户类型</th>
            <th>是否删除</th>
            <th>是否修改</th>
        </tr>
        <s:iterator value="#request.userlist" id="st">
            <tr>
            <td align="center"><s:property value="#st.id"/>
            <td align="center"><s:property value="#st.name"/>
            <td align="center"><s:property value="#st.password"/>
            <td align="center"><s:property value="#st.type"/>
            <td><a href="userdelete.action?id=<s:property value='#st.id'/> ">delete</a></td>
            </tr>
        </s:iterator>
    </table>
</center>
</body>
</html>
