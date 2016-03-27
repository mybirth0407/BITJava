package jdbc.bookshop.dao;

import jdbc.bookshop.vo.AuthorVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
    private Connection getConnection() {
        Connection conn  = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/webdb";
            conn = DriverManager.getConnection(
                url, "yedarm", "roalclssha4!"
            );
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public List<AuthorVo> getList() {
        List<AuthorVo> list = new ArrayList<AuthorVo>();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            /* Driver load */
            System.out.println("jdbc 드라이버 로딩 성공");


            /* Connection */
            System.out.println("데이터베이스 연결 성공");
            assert conn != null;
            conn = getConnection();

            /* Statement create */
            stmt = conn.createStatement();

            /* SQL run */
            String sql = "select no, name from author";
            rs = stmt.executeQuery(sql);

            /* Data passed */
            while (true) {
                if (!rs.next()) {
                    break;
                }
                Long no = rs.getLong(1);
                String name = rs.getString(2);

                AuthorVo authorVo = new AuthorVo();
                authorVo.setNo(no);
                authorVo.setName(name);

                list.add(authorVo);
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
            }
        }
        return list;
    }

    public static void insert(AuthorVo authorVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1. 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");

            //2. Connection 얻기
            String url = "jdbc:mariadb://localhost/webdb";
            conn = DriverManager.getConnection(url, "yedarm", "roalclssha4!");

            //3. Statement 준비
            String sql = "insert into author values(null, ?)";
            pstmt = conn.prepareStatement(sql);

            //4. bind
            pstmt.setString(1, authorVo.getName());

            //4. SQL 실행
            pstmt.executeUpdate();

        }
        catch (ClassNotFoundException ex) {
            System.out.println("드라이버를 찾을 수 없습니다:" + ex);
        }
        catch (SQLException ex) {
            System.out.println("SQL 오류:" + ex);
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
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
