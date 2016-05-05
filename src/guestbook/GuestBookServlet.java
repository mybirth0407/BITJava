package guestbook;

import db.WebDBConnection;
import guestbook.dao.GuestBookDao;
import guestbook.vo.GuestBookVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GuestBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String actionName = req.getParameter("in");

        if ("add".equals(actionName)) {
            String name = req.getParameter("name");
            String message = req.getParameter("content");
            String passwd = req.getParameter("passwd");

            GuestBookVo guestbookVo = new GuestBookVo();
            guestbookVo.setName(name);
            guestbookVo.setMessage(message);
            guestbookVo.setPasswd(passwd);

            GuestBookDao guestbookDao =
                new GuestBookDao(new WebDBConnection());
            guestbookDao.insert(guestbookVo);

            res.sendRedirect("/main");
        }
        else if ("delete".equals(actionName)) {
            String no = req.getParameter("no");
            String passwd = req.getParameter("passwd");

            GuestBookVo guestBookVo = new GuestBookVo();
            guestBookVo.setNo(Long.parseLong(no));
            guestBookVo.setPasswd(passwd);

            GuestBookDao guestBookDao =
                new GuestBookDao(new WebDBConnection());
            guestBookDao.delete(guestBookVo);

            res.sendRedirect("/main");
        }
        else if ("deleteform".equals(actionName)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(
                "/WEB-INF/guestbook/views/deleteform.jsp");
            requestDispatcher.forward(req, res);
        }
        else {
            /* default action(list, index) */
            GuestBookDao guestbookDao =
                new GuestBookDao(new WebDBConnection());
            List<GuestBookVo> list = guestbookDao.getList();

            /* forwarding 전에 jsp로 보낼 data를 request 안에 저장 */
            req.setAttribute("list", list);

            /* forwarding(request 확장, request dispatcher) */
            RequestDispatcher requestDispatcher =
                req.getRequestDispatcher(
                    "/WEB-INF/guestbook/views/list.jsp");
            requestDispatcher.forward(req, res);
        }
    }
}
