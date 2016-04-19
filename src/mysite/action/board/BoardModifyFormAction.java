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

public class BoardModifyFormAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String no = req.getParameter("no");

        BoardDao boardDao = new BoardDao(new WebDBConnection());
        BoardVo boardVo = boardDao.get(Long.parseLong(no));

        req.setAttribute("boardVo", boardVo);
        WebUtil.forward(req, res,
            "/WEB-INF/mysite/views/board/modify.jsp");
    }
}