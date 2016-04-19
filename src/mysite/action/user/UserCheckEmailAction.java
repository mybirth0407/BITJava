package mysite.action.user;

import mysite.dao.UserDao;
import mysite.db.WebDBConnection;
import mysite.vo.UserVo;
import mysite.web.action.Action;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserCheckEmailAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        res.setContentType("application/json;charset=utf-8");

        /**
         * {
         * result: "success" or "fail"
         * message: 실패한 경우에 어떤 fail인지 메세지 전송
         * data: 통신 데이터
         * }
         *
         * 통신이 성공한 경우
         * {result: "success", data: true} ->이메일 사용 가능
         * {result: "success", data: false} ->이메일 사용 불가
         */
        Map<String, Object> map = new HashMap<String, Object>();
        String email = req.getParameter("email");
        UserDao userDao = new UserDao(new WebDBConnection());
        UserVo userVo = userDao.get(email);
        System.out.println(userVo);
        map.put("result", "success");
        map.put("data", userVo == null);
        PrintWriter out = res.getWriter();
        JSONObject jsonObject = JSONObject.fromObject(map);
        out.println(jsonObject.toString());

//        out.println(jsonString);
    }
}
