<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-12
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    String exceptionType= exception.getClass().getName();
    String exceptionMessage= exception.getMessage();
  %>

 <h1>
   <%=exceptionType%>
   <br>
   <%=exceptionMessage%>
 </h1>


</body>
</html>
