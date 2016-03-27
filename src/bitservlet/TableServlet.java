package bitservlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class TableServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        doPost(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String sRow = req.getParameter("r");
        if (sRow == null) {
            sRow = "3";
        }

        String sCol = req.getParameter("c");
        if (sCol == null) {
            sCol = "3";
        }

        int nRow = Integer.parseInt(sRow);
        int nCol = Integer.parseInt(sCol);

        /* Response(header) */
        res.setContentType("text/html;charset=utf-8");
        /* Response(Body) */
        PrintWriter out = res.getWriter();

        out.println("<table border='1' cellpadding='1', cellspacing='1'>");
        for (int i = 0; i < nRow; i++) {
            out.println("<tr>");

            for (int  j = 0; j < nCol; j++) {
                out.println("<td>cell(" + i + " ," + j + ")</td>");
            }
            out.println("</tr>");
        }
        out.println("</table");
    }
}
