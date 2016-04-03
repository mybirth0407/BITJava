package mysite.action;

import db.WebDBConnection;
import guestbook.dao.GuestBookDao;
import guestbook.vo.GuestBookVo;
import web.WebUtil;
import web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");
        String content = req.getParameter("content");

        GuestBookVo guestBookVo = new GuestBookVo();
        guestBookVo.setName(name);
        guestBookVo.setMessage(content);
        guestBookVo.setPasswd(passwd);

        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        guestBookDao.insert(guestBookVo);
        WebUtil.redirect(req, res, "/guestbook");
    }
}
