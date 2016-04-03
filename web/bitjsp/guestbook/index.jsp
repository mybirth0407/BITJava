<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="guestbook.dao.GuestBookDao" %>
<%@ page import="db.WebDBConnection" %>
<%@ page import="guestbook.vo.GuestBookVo" %>
<%@ page import="java.util.List" %>

<%
  response.setContentType("text/html;charset=utf-8");
  request.setCharacterEncoding("utf-8");
  GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
  List<GuestBookVo> list = guestBookDao.getList();
  int i = 1;
%>

<html>
<head>
  <meta http-equiv="Content-Type" message="text/html; charset=UTF-8">
  <title>방명록</title>
</head>
<body>
<form action="/bitjsp/guestbook/add.jsp" method="post">
  <table border=1 width=500>
    <tr>
      <td>이름</td>
      <td><input type="text" name="name"></td>
      <td>비밀번호</td>
      <td><input type="passwd" name="passwd"></td>
    </tr>
    <tr>
      <td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
    </tr>
    <tr>
      <td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
    </tr>
  </table>
</form>
<br>
<%
  for (GuestBookVo guestBookVo: list) {
%>
<table width=510 border=1>
  <tr>
    <td><%=i++%></td>
    <td><%=guestBookVo.getName()%></td>
    <td><%=guestBookVo.getRegDate()%></td>
    <td><a href =
             "/bitjsp/guestbook/deleteform.jsp?no=<%=guestBookVo.getNo()%>">
      삭제
    </a></td>
  </tr>
  <tr>
    <td colspan=4><%=guestBookVo.getMessage()%></td>
  </tr>
</table>
<%
  }
%>
<br>
</body>
</html>