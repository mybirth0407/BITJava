package mysite.action.user;

import mysite.dao.UserDao;
import mysite.db.WebDBConnection;
import mysite.vo.UserVo;
import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserModifyFormAction implements Action {

    @Override
    public void execute(
        HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null) {
            WebUtil.redirect(req, res, "/main");
            return;
        }

        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            WebUtil.redirect(req, res, "/main");
            return;
        }

        UserDao userDao = new UserDao(new WebDBConnection());
        UserVo userVo = userDao.get(authUser.getNo());

        req.setAttribute("userVo", userVo);
        WebUtil.forward(req, res,
            "/WEB-INF/mysite/views/user/modifyform.jsp");
    }
}