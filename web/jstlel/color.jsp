<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  if ("1".equals(request.getParameter("color"))) {
%>
<span style="color: red">빨강</span>
<%
  }
  else if ("2".equals(request.getParameter("color"))) {
%>
<span style="color: green">녹색</span>
<%
  }
  else if ("3".equals(request.getParameter("color"))) {
%>
<span style="color: blue">파랑</span>
<%
  }
%>
</body>
</html>
