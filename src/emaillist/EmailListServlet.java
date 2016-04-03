package emaillist;

import db.WebDBConnection;
import emaillist.dao.EmailListDao;
import emaillist.vo.EmailListVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmailListServlet extends HttpServlet {
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

        if ("insert".equals(actionName)) {
            String firstName = req.getParameter("fn");
            String lastName = req.getParameter("ln");
            String email = req.getParameter("email");

            EmailListVo emailListVo = new EmailListVo();
            emailListVo.setFirstName(firstName);
            emailListVo.setLastName(lastName);
            emailListVo.setEmail(email);

            EmailListDao emailListDao =
                new EmailListDao(new WebDBConnection());
            emailListDao.insert(emailListVo);

            res.sendRedirect("/emaillist/EmailListServlet");
        }
        else if ("form".equals(actionName)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(
                "/WEB-INF/views/emaillist/form.jsp");
            requestDispatcher.forward(req, res);

        }
        else {
            /* default action(list, index) */
            EmailListDao emailListDao =
                new EmailListDao(new WebDBConnection());
            List<EmailListVo> list = emailListDao.getList();

            /* forwarding 전에 jsp로 보낼 data를 request 안에 저장 */
            req.setAttribute("list", list);

            /* forwarding(request 확장, request dispatcher) */
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(
                    "/WEB-INF/views/emaillist/index.jsp");
            requestDispatcher.forward(req, res);
        }
    }
}
