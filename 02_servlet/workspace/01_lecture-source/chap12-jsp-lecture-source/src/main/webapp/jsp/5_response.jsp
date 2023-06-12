<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-12
  Time: 오후 4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  <%--%>
<%--    String menu=(String) request.getAttribute("menuName");--%>
<%--    //request를 어디서 받지 않았는데 쓸 수 있는 이유는 request가 내장 객체이기 때문--%>

<%--    int amount=(Integer) request.getAttribute("amount");--%>
<%--    int orderPirce=(Integer) request.getAttribute("orderPrice");--%>
<%--  %>--%>

<%--<h3> 주문하신 음식 : <%=menu%></h3>--%>
<%--<h3> 주문하신 수량 : <%=amount%>인분</h3>--%>
<%--<h3> 주문하신 금액 : <%=orderPirce%></h3>--%>

<h3>주문하신 음식 : ${requestScope.menuName}</h3>
<h3>주문하신 음식 : ${amount}</h3>
<h3>주문하신 음식 : ${orderPrice}</h3>
<%-- a el(expression language : 간단하게 request받은걸 출력할 수 잇음--%>

</body>
</html>
