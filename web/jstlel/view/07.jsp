<%@ page import="jstlel.vo.UserVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
  UserVo userVo = new UserVo();
  userVo.setNo(0L);
  userVo.setName("둘리0");

  pageContext.setAttribute("user", userVo);

  String name = "성예닮";
  pageContext.setAttribute("name", name);

%>
--${name }--
<html>
<head>
  <meta http-equiv="Content-Type" message="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h3>범위 우선순위</h3>
<h4>작은 범위부터 찾는다</h4>
${user.no } <br>
${user.name } <br><br>

<h4>pageScope</h4>
${pageScope.user.no } <br>
${pageScope.user.name } <br><br>

<h4>requestScope</h4>
${requestScope.user.no } <br>
${requestScope.user.name } <br><br>

<h4>sessionScope</h4>
${sessionScope.user.no } <br>
${sessionScope.user.name } <br><br>

<h4>applicationScope</h4>
${applicationScope.user.no } <br>
${applicationScope.user.name } <br>

</body>
</html>