<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String sRow = request.getParameter("r");
  if (sRow == null) {
    /* 3 is default */
    sRow = "3";
  }

  String sCol = request.getParameter("c");
  if (sCol == null) {
    /* 3 is default */
    sCol = "3";
  }

  int nRow = Integer.parseInt(sRow);
  int nCol = Integer.parseInt(sCol);
%>

<html>
<head>
  <title>Title</title>
</head>
<body>
  <table border="1" cellpadding="10" cellspacing="0">
    <%
      for (int i = 0; i < nRow; i++) {
    %>
    <tr>
      <%
        for (int j = 0; j < nCol; j++) {
      %>
      <td>cell(<%= i %>, <%= j %>)</td>
      <%
        }
      %>
    </tr>
    <%
      }
    %>
    </tr>
  </table>
</body>
</html>
