<%@ page import="guestbook.vo.GuestBookVo" %>
<%@ page import="db.WebDBConnection" %>
<%@ page import="guestbook.dao.GuestBookDao" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
  response.setContentType("text/html;charset=utf-8");
  request.setCharacterEncoding("utf-8");
  String no = request.getParameter("no");
  String passwd = request.getParameter("passwd");

  GuestBookVo guestBookVo = new GuestBookVo();
  guestBookVo.setNo(Long.parseLong(no));
  guestBookVo.setPasswd(passwd);

  GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
  guestBookDao.delete(guestBookVo);

  response.sendRedirect("/bitjsp//guestbook/index.jsp");
%>
<html>
<head>
  <title>삭제된거임</title>
</head>
<body>
<h1>삭제성공이다!</h1>
<%=no%>
<br>
<%=passwd%>
</body>
</html>