package mysite.action.board;

import mysite.dao.BoardDao;
import mysite.db.WebDBConnection;
import mysite.vo.BoardVo;
import mysite.vo.UserVo;
import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BoardReplyAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null) {
            WebUtil.redirect(req, res, "/board");
            return;
        }

        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            WebUtil.redirect(req, res, "/board");
            return;
        }

        BoardDao boardDao = new BoardDao(new WebDBConnection());
        String no = req.getParameter("no");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardVo parentBoardVo = boardDao.get(Long.parseLong(no));
        BoardVo boardVo = new BoardVo();
        boardVo.setTitle(title);
        boardVo.setContent(content);
        boardVo.setUserNo(authUser.getNo());
        boardVo.setGroupNo(parentBoardVo.getGroupNo());
        boardVo.setOrderNo(parentBoardVo.getOrderNo() + 1);
        boardVo.setDepth(parentBoardVo.getDepth() + 1);

        /* 부모의 그룹id랑 오더id랑 깊이 */
        boardDao.reply(boardVo);
//        boardDao.write(boardVo);
        WebUtil.redirect(req, res, "/board");
    }
}
