package mysite.action.guestbook;

import mysite.dao.GuestBookDao;
import mysite.db.WebDBConnection;
import mysite.vo.GuestBookVo;
import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GuestBookInsertAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");
        String message = req.getParameter("message");

        GuestBookVo guestBookVo = new GuestBookVo();
        guestBookVo.setName(name);
        guestBookVo.setMessage(message);
        guestBookVo.setPasswd(passwd);

        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        guestBookDao.insert(guestBookVo);
        WebUtil.redirect(req, res, "/guestbook");
    }
}
