package jdbc;

import java.sql.*;

public class JDBCTestUpdate {
    public static void main(String args[]) {
        Connection conn  = null;
        Statement stmt = null;

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
            String sql =
                "update pet " +
                "set gender = 'f' " +
                "where name='마음이'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
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
    }
}
