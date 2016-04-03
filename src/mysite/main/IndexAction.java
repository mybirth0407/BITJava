package mysite.main;

import web.WebUtil;
import web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
//        Cookie cookie = new Cookie("testCookie", "helloworld");
//        cookie.setMaxAge(60 * 60 * 24 * 1);
//        cookie.setPath("/");
//        res.addCookie(cookie);
        WebUtil.forward(req, res, "/WEB-INF/mysite/views/main/index.jsp");
    }
}
