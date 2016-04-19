package mysite.action.user;

import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserJoinSuccessAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        WebUtil.forward(
            req, res, "/WEB-INF/mysite/views/user/joinsuccess.jsp");
    }
}
