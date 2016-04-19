package mysite.action.guestbook;

import mysite.dao.GuestBookDao;
import mysite.db.WebDBConnection;
import mysite.vo.GuestBookVo;
import mysite.web.action.Action;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuestBookAjaxListAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String page = req.getParameter("page");
        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        List<GuestBookVo> list = guestBookDao.getList(Long.parseLong(page));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "success");
        map.put("data", list);
        JSONObject jsonObject = JSONObject.fromObject(map);
        res.setContentType("application/json;charset=utf-8");
        res.getWriter().println(jsonObject);
    }
}
