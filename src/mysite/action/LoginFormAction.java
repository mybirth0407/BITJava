package mysite.action;

import web.WebUtil;
import web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFormAction implements Action {
    @Override
    public void execute(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//        if (cookies == null) {
//            return;
//        }
//
//        for (Cookie cookie: cookies) {
//            System.out.println(cookie.getName() + ": " + cookie.getValue());
//        }
        WebUtil.forward(
            request, response, "/WEB-INF/mysite/views/user/loginform.jsp");
    }
}
