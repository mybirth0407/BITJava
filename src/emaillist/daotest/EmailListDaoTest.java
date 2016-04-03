package emaillist.daotest;

import db.WebDBConnection;
import emaillist.dao.EmailListDao;
import emaillist.vo.EmailListVo;

import java.util.List;

public class EmailListDaoTest {
    public static void main(String args[]) {
//        insert();
        getList();
    }

    public static void insert() {
        EmailListVo emailListVo = new EmailListVo();
        emailListVo.setFirstName("둘");
        emailListVo.setLastName("리");
        emailListVo.setEmail("dooly@gmail.com");

        EmailListDao emailListDao = new EmailListDao(new WebDBConnection());
        emailListDao.insert(emailListVo);
    }

    public static void getList() {
        EmailListDao emailListDao = new EmailListDao(new WebDBConnection());
        List<EmailListVo> list = emailListDao.getList();

        for (EmailListVo emailListVo: list) {
            System.out.println(emailListVo);
        }
    }
}
