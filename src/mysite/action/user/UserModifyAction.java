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

public class UserModifyAction implements Action {
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

        String name = req.getParameter("name");
        String password = req.getParameter("passwd");
        String gender = req.getParameter("gender");

        UserVo userVo = new UserVo();
        userVo.setNo(authUser.getNo());
        userVo.setName(name);
        userVo.setPasswd(password);
        userVo.setGender(gender);

        // db 업데이트
        UserDao userDao = new UserDao(new WebDBConnection());
        userDao.update(userVo);

        // 세션 저장객체 내용 변경
        authUser.setName(name);

        // 리다이렉트
        WebUtil.redirect(req, res, "/main");
    }
}