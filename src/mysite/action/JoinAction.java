package mysite.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import mysite.dao.UserDao;
import mysite.vo.UserVo;
import db.WebDBConnection;
import web.WebUtil;
import web.action.Action;

public class JoinAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        /* Dao */
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");
        String gender = req.getParameter("gender");

        UserVo userVo = new UserVo();
        userVo.setName(name);
        userVo.setEmail(email);
        userVo.setPasswd(passwd);
        userVo.setGender(gender);

        UserDao userDao = new UserDao(new WebDBConnection());
        userDao.insert(userVo);

//        WebUtil.forward(req, res, "/mysite/user?a=joinsuccess.jsp");
        WebUtil.redirect(req, res, "/user?a=joinsuccess");
    }
}
