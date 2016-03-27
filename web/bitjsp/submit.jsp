<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("utf-8");
  String name = request.getParameter("n");
  String password = request.getParameter("p");
  String gender = request.getParameter("g");
  String hobbies[] = request.getParameterValues("h");
  String birthYear = request.getParameter("b");
%>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <%=name %> <br>
  <%=password %> <br>
  <%=gender %> <br>
  <%
    for (String hobby: hobbies) {
  %>
    <%=hobby %>
  <%
    }
  %>
  <br>
  <%= birthYear %>
  <a href="form.jsp"> 폼으로 돌아가기 </a>
</body>
</html>
