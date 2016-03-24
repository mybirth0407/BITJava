package jdbc.bookshop.dao.test;

import jdbc.bookshop.dao.BookDao;
import jdbc.bookshop.vo.BookVo;

public class BookDaoTest {
    public static void main(String args[]) {
        insertTest();
    }

    public static void insertTest() {
        BookVo bookVo = new BookVo();
        BookDao bookDao = new BookDao();

        bookVo.setTitle("twilight");
        bookVo.setAuthorNo(1L);
        bookDao.insert(bookVo);
    }

    public static void updateStateTest() {
        BookVo bookVo = new BookVo();
        bookVo.setNo(6L);
    }
}
