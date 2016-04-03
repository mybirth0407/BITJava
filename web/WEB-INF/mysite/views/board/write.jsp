<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>mysite</title>
  <meta http-equiv="message-type" message="text/html; charset=utf-8">
  <link href="/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
  <jsp:include
    page="/WEB-INF/mysite/views/include/header.jsp"/>
  <div id="message">
    <div id="board">
      <form class="board-form" method="post" action="/mysite/board">
        <input type="hidden" name="a" value="write">
        <table class="tbl-ex">
          <tr>
            <th colspan="2">글쓰기</th>
          </tr>
          <tr>
            <td class="label">제목</td>
            <td><input type="text" name="title" value=""></td>
          </tr>
          <tr>
            <td class="label">내용</td>
            <td>
              <textarea id="message" name="message"></textarea>
            </td>
          </tr>
        </table>
        <div class="bottom">
          <a href="/board">취소</a>
          <input type="submit" value="등록">
        </div>
      </form>
    </div>
  </div>
  <jsp:include
    page="/WEB-INF/mysite/views/include/navigation.jsp"/>
  <jsp:include
    page="/WEB-INF/mysite/views/include/footer.jsp"/>
</div>
</body>
</html>
