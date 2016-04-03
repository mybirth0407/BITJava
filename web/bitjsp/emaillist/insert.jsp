<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="emaillist.vo.EmailListVo" %>
<%@ page import="emaillist.dao.EmailListDao" %>
<%@ page import="db.WebDBConnection" %>
<%
  String firstName = request.getParameter("fn");
  String lastName = request.getParameter("ln");
  String email = request.getParameter("email");

  EmailListVo emailListVo = new EmailListVo();
  emailListVo.setFirstName(firstName);
  emailListVo.setLastName(lastName);
  emailListVo.setEmail(email);

  EmailListDao emailListDao = new EmailListDao(new WebDBConnection());
  emailListDao.insert(emailListVo);

  response.sendRedirect("/bitjsp/emaillist");
%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1> 성공했느니라 </h1>
</body>
</html>
