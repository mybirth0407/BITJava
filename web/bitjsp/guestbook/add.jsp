<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="guestbook.dao.GuestBookDao" %>
<%@ page import="guestbook.vo.GuestBookVo" %>
<%@ page import="db.WebDBConnection" %>
<%
  response.setContentType("text/html;charset=utf-8");
  request.setCharacterEncoding("utf-8");
  String name = request.getParameter("name");
  String message = request.getParameter("message");
  String passwd = request.getParameter("passwd");

  GuestBookVo guestBookVo = new GuestBookVo();
  guestBookVo.setName(name);
  guestBookVo.setMessage(message);
  guestBookVo.setPasswd(passwd);

  GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
  guestBookDao.insert(guestBookVo);

  response.sendRedirect("/bitjsp/guestbook/index.jsp");
%>
<html>
<head>
  <title>add</title>
</head>
<body>
<h1> 성공했다! </h1>
</body>
</html>
