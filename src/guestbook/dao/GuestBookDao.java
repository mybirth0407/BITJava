package guestbook.dao;

import db.DBConnection;
import guestbook.vo.GuestBookVo;

import java.sql.*;
import java.util.*;

public class GuestBookDao {
    private DBConnection dbConnection;

    public GuestBookDao(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void insert(GuestBookVo guestBookVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbConnection.getConnection();
            String sql =
                "insert into guestbook " +
                "values(null, ?, now(), ?, password(?))";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guestBookVo.getName());
            pstmt.setString(2, guestBookVo.getMessage());
            pstmt.setString(3, guestBookVo.getPasswd());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(GuestBookVo guestBookVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbConnection.getConnection();
            String sql =
                "delete from guestbook " +
                "where no = ? " +
                    "and passwd = password(?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, guestBookVo.getNo());
            pstmt.setString(2, guestBookVo.getPasswd());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<GuestBookVo> getList() {
        List<GuestBookVo> list = new ArrayList<GuestBookVo>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = dbConnection.getConnection();
            stmt = conn.createStatement();
            String sql =
                "select * " +
                "from guestbook " +
                "order by reg_date desc";
            rs = stmt.executeQuery(sql);

            while (true) {
                if (rs.next() == false) {
                    break;
                }

                Long no = rs.getLong(1);
                String name = rs.getString(2);
                String regDate = rs.getString(3);
                String message = rs.getString(4);
                String passwd = rs.getString(5);

                GuestBookVo guestBookVo = new GuestBookVo();
                guestBookVo.setNo(no);
                guestBookVo.setName(name);
                guestBookVo.setRegDate(regDate);
                guestBookVo.setMessage(message);
                guestBookVo.setPasswd(passwd);

                list.add(guestBookVo);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
