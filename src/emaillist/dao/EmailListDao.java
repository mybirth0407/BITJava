package emaillist.dao;

import db.DBConnection;
import emaillist.vo.EmailListVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailListDao {
    private DBConnection dbConnection;

    public EmailListDao(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void insert(EmailListVo emailListVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbConnection.getConnection();
            String sql =
                "insert into emaillist " +
                "values(null, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, emailListVo.getFirstName());
            pstmt.setString(2, emailListVo.getLastName());
            pstmt.setString(3, emailListVo.getEmail());
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

    public List<EmailListVo> getList() {
        List<EmailListVo> list = new ArrayList<EmailListVo>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = dbConnection.getConnection();
            stmt = conn.createStatement();
            String sql =
                "select no, first_name, last_name, email " +
                "from emaillist";
            rs = stmt.executeQuery(sql);

            while (true) {
                if (rs.next() == false) {
                    break;
                }

                Long no = rs.getLong(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);

                EmailListVo emailListVo = new EmailListVo();
                emailListVo.setNo(no);
                emailListVo.setFirstName(firstName);
                emailListVo.setLastName(lastName);
                emailListVo.setEmail(email);

                list.add(emailListVo);
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

