package jstlel.servlet;

import jstlel.vo.UserVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/07")
public class _07Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        UserVo userVo1 = new UserVo();
        userVo1.setNo(1L);
        userVo1.setName("둘리1");
        request.setAttribute("user", userVo1);

        UserVo userVo2 = new UserVo();
        userVo2.setNo(2L);
        userVo2.setName("둘리2");
        HttpSession session = request.getSession(true);
        session.setAttribute("user", userVo2);

        UserVo userVo3 = new UserVo();
        userVo3.setNo(3L);
        userVo3.setName("둘리3");
        getServletContext().setAttribute("user", userVo3);

        request.getRequestDispatcher(
            "/jstlel/view/07.jsp").forward(request, response);
    }
}
