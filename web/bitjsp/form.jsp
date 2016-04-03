
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <form action = "submit.jsp" method = "post">
    이름:
    <input type = "text" name = "n" value = ""/>
    <br>
    비밀번호:
    <input type = "passwd" name = "p" value = ""/>
    <br>
    성별:
    <input type = "radio" name = "g" value = "m"/> 남자
    <input type = "radio" name = "g" value = "f"
               checked = "checked"/> 여자
    <br>
    취미:
    <input type = "checkbox" name = "h" value = "reading"> 독서
    <input type = "checkbox" name = "h" value = "programming"> 프로그래밍
    <input type = "checkbox" name = "h" value = "swimming"> 수영
    생년:
      <select name = "b">
        <option value = "1980"> 1980년
        <option value = "1981"> 1981년

        </option>
      </select>

    <br>

    자기소개
    <textarea <jsp:text> </jsp:text>'
    <br>
    <<textarea style = "width:200px"

    <input type = "submit" value = 200px , height = 200px border solide
           #f00, bacogound--colof #f2ddd
     4000 />
    <%--<input type = "image" src =--%>
      <%--"https://s3.amazonaws.com/s3.imagefinder.co/uploads/2016/03/18134541/HNCK5769-880x587.jpg"/>--%>
  </form>
</body>
</html>
