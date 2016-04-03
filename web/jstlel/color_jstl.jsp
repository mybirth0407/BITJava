<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
  <meta http-equiv="Content-Type" message="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<c:if test="${param.color == 1 }">
  <span style="color: red">빨강</span>
</c:if>
<c:if test="${param.color == 2 }">
  <span style="color: green">녹색</span>
</c:if>
<c:if test="${param.color == 3 }">
  <span style="color: blue">파랑</span>
</c:if>
</body>
</html>
