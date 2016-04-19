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
import java.util.Map;

public class GuestBookAjaxInsertAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");
        String message = req.getParameter("message");

        GuestBookVo guestBookVo = new GuestBookVo();

        guestBookVo.setName(name);
        guestBookVo.setPasswd(passwd);
        guestBookVo.setMessage(message);

        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        Long no = guestBookDao.insert(guestBookVo);
        guestBookVo = guestBookDao.get(no);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "success");
        map.put("data", guestBookVo);
        
        JSONObject jsonObject = JSONObject.fromObject(map);
        res.setContentType("application/json;charset=utf-8");
        res.getWriter().println(jsonObject);
    }
}
