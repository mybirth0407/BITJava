package jstlel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/02")
public class _02Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = "으악";
        int iValue = 10;
        float fValue = 3.14f;
        boolean bValue = true;

        request.setAttribute("name", name);
        request.setAttribute("iValue", iValue);
        request.setAttribute("fValue", fValue);
        request.setAttribute("bValue", bValue);

        request.getRequestDispatcher(
            "/jstlel/view/02.jsp").forward(request, response);
    }
}
