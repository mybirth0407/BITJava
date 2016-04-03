package mysite.action;

import db.WebDBConnection;
import mysite.dao.BoardDao;
import mysite.vo.BoardVo;
import web.WebUtil;
import web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardListAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        BoardDao boardDao = new BoardDao(new WebDBConnection());
        List<BoardVo> boardVoList = boardDao.getList();

        req.setAttribute("list", boardVoList);

        WebUtil.forward(req, res, "/WEB-INF/mysite/views/board/list.jsp");
    }

}
