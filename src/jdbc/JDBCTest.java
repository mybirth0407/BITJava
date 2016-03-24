package jdbc;

import java.sql.*;

public class JDBCTest {
    public static void main(String args[]) {
        Connection conn  = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            /* Driver load */
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("jdbc 드라이버 로딩 성공");

            String url = "jdbc:mariadb://localhost:3306/webdb";

            /* Connection */
            conn = DriverManager.getConnection(
                url, "webdb", "webdb"
            );
            System.out.println("데이터베이스 연결 성공");

            /* Statement create */
            stmt = conn.createStatement();

            /* SQL run */
            String sql = "select * from pet";
            rs = stmt.executeQuery(sql);

            while (true) {
                if (!rs.next()) {
                    break;
                }
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            }
        }
    }
}
