package mysite.action.board;

import mysite.action.config.Config;
import mysite.dao.BoardDao;
import mysite.db.WebDBConnection;
import mysite.vo.BoardVo;
import mysite.web.WebUtil;
import mysite.web.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardListAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        long page;

        if (req.getParameter("page") == null) {
            System.out.println("페이지 널이다 망했음");
            page = 1L;
        }
        else if (req.getParameter("page") == "") {
            System.out.println("인자가 없어어어커컹컹커겈");
            page = 1L;
        }
        else {
            page = Long.parseLong(req.getParameter("page"));
        }

        String keyword = req.getParameter("keyword");
        BoardDao boardDao = new BoardDao(new WebDBConnection());
        List<BoardVo> boardVolist = boardDao.pageGetList(
            keyword, page, Config.N_LIST);
        req.setAttribute("list", boardVolist);

        long left = 1, right = 1;
        long startPage, lastPage;
        long searchResult = boardDao.searchCount(keyword);
        long maxPage = searchResult / Config.N_LIST;

        if (searchResult % Config.N_LIST != 0) {
            maxPage++;
        }

        if (page < 1 || page > maxPage) {
            page = 1;
        }

        long maxPageGroup = maxPage / Config.N_PAGE;

        if (maxPage % Config.N_PAGE != 0) {
            maxPageGroup++;
        }

        long selectedPageGroup = page / Config.N_PAGE;

        if (page % Config.N_PAGE != 0) {
            selectedPageGroup++;
        }

        if (selectedPageGroup == 1) {
            left = 0;
        }

        if (selectedPageGroup == maxPageGroup) {
            right = 0;
        }

        startPage = (selectedPageGroup - 1) * Config.N_PAGE + 1;
        lastPage = (selectedPageGroup) * Config.N_PAGE;

        if (lastPage > maxPage) {
            lastPage = maxPage;
        }

        System.out.println("selectedPageGroup: " + selectedPageGroup);
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        System.out.println("startPage: " + startPage);
        System.out.println("lastPage: " + lastPage);
        System.out.println("page: " + page);
        System.out.println("total: " + searchResult);

        Map<String, Long> map = new HashMap<String, Long>();
        map.put("left", left);
        map.put("right", right);
        map.put("startPage", startPage);
        map.put("lastPage", lastPage);
        map.put("page", page);
        map.put("total", searchResult);
        map.put("N_PAGE", Config.N_PAGE);
        map.put("N_LIST", Config.N_LIST);
        req.setAttribute("pageMap", map);

        WebUtil.forward(req, res, "/WEB-INF/mysite/views/board/list.jsp");
    }
}
