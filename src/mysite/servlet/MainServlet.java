package mysite.servlet;

import mysite.main.MainActionFactory;
import mysite.web.action.Action;
import mysite.web.action.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String actionName = request.getParameter("a");
        ActionFactory actionFactory = new MainActionFactory();
        Action action = actionFactory.getAction(actionName);
        action.execute(request, response);
    }
}
