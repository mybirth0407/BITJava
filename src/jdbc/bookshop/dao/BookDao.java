package jdbc.bookshop.dao;

import jdbc.bookshop.vo.BookVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
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

    public List<BookVo> getList() {
        List<BookVo> list = new ArrayList<BookVo>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();

            String sql =
                "select b.no, b.title, " +
                "if (b.state = 'rent', '대여중', '재고있다') as state, " +
                "a.name " +
                "from book b, author a " +
                "where b.author_no = b.no " +
                "order by a.no asc";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Long no = rs.getLong(1);
                String title = rs.getString(2);
                String state = rs.getString(3);
                String authorName = rs.getString(4);

                BookVo bookVo = new BookVo();
                bookVo.setNo(no);
                bookVo.setTitle(title);
                bookVo.setState(state);
                bookVo.setAuthorName(authorName);

                list.add(bookVo);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(BookVo bookVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1. 드라이버 로드
            conn = getConnection();
            //2. Connection 얻기

            //3. Statement 준비
            String sql = "insert into book values(" +
                "null, ?, 'available', ?" +
                ")";
            pstmt = conn.prepareStatement(sql);

            //4. bind
            pstmt.setString(1, bookVo.getTitle());
            pstmt.setLong(2, bookVo.getAuthorNo());

            //4. SQL 실행
            pstmt.executeUpdate();

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

    public void updateState(BookVo bookVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql =
                "update book set state = ? where no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookVo.getState());
            pstmt.setLong(2, bookVo.getNo());
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
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public BookVo get(Long no) {
        BookVo bookVo = new BookVo();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1. 드라이버 로드
            conn = getConnection();
            //2. Connection 얻기

            //3. Statement 준비
            String sql =
                "select b.no, b.title, " +
                "if (b.state = 'rent', '대여중', '재고있다') as state, " +
                "a.name " +
                "from book b, author a " +
                "where b.author_no = b.no " +
                "and b.no = ?";
            pstmt = conn.prepareStatement(sql);

            //4. bind
            pstmt.setLong(1, no);

            //4. SQL 실행
            pstmt.executeQuery();

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
        return bookVo;
    }
}
