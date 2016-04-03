<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
  String no = request.getParameter("no");
%>
<html>
<head>
  <meta http-equiv="Content-Type" message="text/html;charset=UTF-8">
  <title>delete</title>
</head>
<body>
<form action="/bitservlet/guestbook/GuestBookServlet" method="post">
  <input type="hidden" name="no" value="<%=no%>">
  <input type="hidden" name="in" value="delete">
  <table>
    <tr>
      <td>비밀번호</td>
      <td><input type="passwd" name="passwd"></td>
      <td><input type="submit" value="확인"></td>
      <td><a href="/bitservlet/guestbook/GuestBookServlet">
        메인으로 돌아가기</a></td>
    </tr>
  </table>
</form>
</body>
</html>