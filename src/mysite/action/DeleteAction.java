package mysite.action;

import db.WebDBConnection;
import mysite.dao.GuestBookDao;
import web.WebUtil;
import web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String no = req.getParameter("no");

        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());

        guestBookDao.delete(Long.parseLong(no));
        WebUtil.redirect(req, res, "/guestbook");
    }
}
