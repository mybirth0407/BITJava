<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
  <title>mysite</title>
  <meta http-equiv="message-type" message="text/html; charset=utf-8">
  <link href="/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
  <c:import url="/WEB-INF/mysite/views/include/header.jsp"/>
  <div id="message">
    <div id="user">
      <form id="join-form" name="joinForm" method="post"
            action="user">
        <input type="hidden" name="a" value="join">
        <label class="block-label" for="name">이름</label>
        <input id="name" name="name" type="text" value="">

        <label class="block-label" for="email">이메일</label>
        <input id="email" name="email" type="text" value="">
        <input type="button" value="id 중복체크">

        <label class="block-label">패스워드</label>
        <input name="passwd" type="password" value="">

        <fieldset>
          <legend>성별</legend>
          <label>여</label> <input type="radio" name="gender" value="f"
                                  checked="checked">
          <label>남</label> <input type="radio" name="gender" value="m">
        </fieldset>

        <fieldset>
          <legend>약관동의</legend>
          <input id="agree-prov" type="checkbox" name="agreeProv" value="y">
          <label>서비스 약관에 동의합니다.</label>
        </fieldset>

        <input type="submit" value="가입하기">

      </form>
    </div>
  </div>
  <c:import url="/WEB-INF/mysite/views/include/navigation.jsp"/>
  <c:import url="/WEB-INF/mysite/views/include/footer.jsp"/>
</div>
</body>
</html>
