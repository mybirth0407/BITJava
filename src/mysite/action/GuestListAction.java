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
import java.util.List;

public class GuestListAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        List<GuestBookVo> guestBookVoList = guestBookDao.getList();

        req.setAttribute("list", guestBookVoList);

        WebUtil.forward(req, res, "/WEB-INF/mysite/views/guestbook/list.jsp");
    }
}
