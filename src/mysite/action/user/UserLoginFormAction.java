package mysite.action.user;

import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginFormAction implements Action {
    @Override
    public void execute(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        WebUtil.forward(
            request, response, "/WEB-INF/mysite/views/user/loginform.jsp");
    }
}
