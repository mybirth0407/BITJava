package mysite.action;

import mysite.dao.UserDao;
import mysite.vo.UserVo;
import db.WebDBConnection;
import web.action.Action;
import web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ModifyAction implements Action {
    @Override
    public void execute(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session == null) {
            WebUtil.redirect(request, response, "/main");
            return;
        }
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            WebUtil.redirect(request, response, "/main");
            return;
        }

        String name = request.getParameter("name");
        String password = request.getParameter("passwd");
        String gender = request.getParameter("gender");

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
        WebUtil.redirect(request, response, "/main");
    }
}