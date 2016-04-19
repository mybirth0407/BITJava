package mysite.action.board;

import mysite.dao.BoardDao;
import mysite.db.WebDBConnection;
import mysite.vo.BoardVo;
import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardModifyAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String no = req.getParameter("no");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardDao boardDao = new BoardDao(new WebDBConnection());
        BoardVo boardVo = boardDao.get(Long.parseLong(no));
        boardVo.setTitle(title);
        boardVo.setContent(content);

        req.setAttribute("boardVo", boardVo);
        boardDao.modify(boardVo);

        WebUtil.redirect(req, res, "/board?a=view&no=" + Long.parseLong(no));
    }
}
