package mysite.action.user;

import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLogoutAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (httpSession == null) {
            WebUtil.redirect(req, res, "/main");
            return;
        }

        /* log out */
        httpSession.removeAttribute("authUser");
        httpSession.invalidate();
        WebUtil.redirect(req, res, "/main");
    }
}
