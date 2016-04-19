package mysite.action.board;

import mysite.dao.BoardDao;
import mysite.db.WebDBConnection;
import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String no = req.getParameter("no");

        BoardDao boardDao = new BoardDao(new WebDBConnection());

        boardDao.delete(Long.parseLong(no));
        WebUtil.redirect(req, res, "/board");
    }
}

