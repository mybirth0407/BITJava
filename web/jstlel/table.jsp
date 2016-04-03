<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String row = request.getParameter("r");
  String col = request.getParameter("c");

  int nRow;

  if (row == null) {
    nRow = 3;
  }
  else {
    nRow = Integer.parseInt(row);
  }

  int nCol;

  if (col == null) {
    nCol = 3;
  }
  else {
    nCol = Integer.parseInt(col);
  }
%>

<html>
<head>
  <title>Title</title>
</head>
<body>
<table border='1px' cellspacing='0' cellpadding='10px'>
  <%
    for (int i = 0; i < nRow; i++) {
  %>
  <tr>
    <%
      for (int j = 0; j < nCol; j++) {
    %>
    <td>cell(<%=i%>, <%=j%>)</td>
    <%
      }
    %>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
