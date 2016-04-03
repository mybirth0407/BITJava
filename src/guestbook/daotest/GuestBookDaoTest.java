package guestbook.daotest;

import java.util.List;
import db.WebDBConnection;
import guestbook.dao.GuestBookDao;
import guestbook.vo.GuestBookVo;

public class GuestBookDaoTest {
    public static void main(String args[]) {
        insert("바보", "멍청이", "2345");
        getList();
//        delete(1L, "1234");
    }

    public static void insert(String name, String message, String passwd) {
        GuestBookVo guestBookVo = new GuestBookVo();
        guestBookVo.setName(name);
        guestBookVo.setMessage(message);
        guestBookVo.setPasswd(passwd);
        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        guestBookDao.insert(guestBookVo);
    }

    public static void getList() {
        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        List<GuestBookVo> list = guestBookDao.getList();

        for (GuestBookVo guestBookVo: list) {
            System.out.println(guestBookVo);
        }
    }

    public static void delete(Long deleteNo, String deletePasswd) {
        GuestBookVo guestBookVo = new GuestBookVo();
        guestBookVo.setNo(deleteNo);
        guestBookVo.setPasswd(deletePasswd);
        GuestBookDao guestBookDao = new GuestBookDao(new WebDBConnection());
        guestBookDao.delete(guestBookVo);
    }
}

