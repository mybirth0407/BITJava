package mysite.action.guestbook;

import mysite.dao.GuestBookDao;
import mysite.db.WebDBConnection;
import mysite.web.action.Action;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GuestBookAjaxDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String stringNo = req.getParameter("no");
        Long no = Long.parseLong(stringNo);
        String passwd = req.getParameter("passwd");


        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        boolean isDelete = true;

        if (guestBookDao.delete(no, passwd) == 0) {
            isDelete = false;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "success");
        map.put("data", isDelete);

        JSONObject jsonObject = JSONObject.fromObject(map);
        res.setContentType("application/json;charset=utf-8");
        res.getWriter().println(jsonObject);
    }
}
