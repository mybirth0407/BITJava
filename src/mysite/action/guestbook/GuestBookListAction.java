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
import java.util.List;

public class GuestBookListAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        List<GuestBookVo> guestBookVoList = guestBookDao.getList();

        req.setAttribute("list", guestBookVoList);

        WebUtil.forward(
            req, res, "/WEB-INF/mysite/views/guestbook/list.jsp");
    }
}
