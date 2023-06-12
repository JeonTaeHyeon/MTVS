<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-12
  Time: 오후 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>include directive</h1>
<div>
    <%@include file="today.jsp" %>
</div>

<%
//  a  String output
//  a 이미 선언되어 있기 때문에 에러 발생
%>


</body>
</html>
