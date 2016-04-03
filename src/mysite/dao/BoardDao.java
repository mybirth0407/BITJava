package mysite.dao;

import db.DBConnection;
import mysite.vo.BoardVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    private DBConnection dbConnection;

    public BoardDao(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void insert(BoardVo boardVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbConnection.getConnection();
            String sql =
                "insert into board " +
                "values(null, ?, ?, now(), ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardVo.getTitle());
            pstmt.setString(2, boardVo.getContent());
            pstmt.setLong(3, boardVo.getUserNo());
            pstmt.setLong(4, boardVo.getGroupNo());
            pstmt.setLong(5, boardVo.getOrderNo());
            pstmt.setLong(6, boardVo.getDepth());

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

    public void delete(Long no) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbConnection.getConnection();
            String sql =
                "delete from board " +
                "where no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, no);

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

    public void modify(BoardVo boardVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
    
        try {
            conn = dbConnection.getConnection();
            String sql =
                "update board " +
                "set content = ? " +
                "WHERE no = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, boardVo.getContent());
            pstmt.setLong(2, boardVo.getNo());

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

    public List<BoardVo> getList() {
        List<BoardVo> list = new ArrayList<BoardVo>();
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
                String title = rs.getString(2);
                String content = rs.getString(3);
                String regDate = rs.getString(4);
                Long userNo = rs.getLong(5);
                Long groupNo = rs.getLong(6);
                Long orderNo = rs.getLong(7);
                Long depth = rs.getLong(8);

                BoardVo boardVo = new BoardVo();
                boardVo.setNo(no);
                boardVo.setTitle(title);
                boardVo.setContent(content);
                boardVo.setRegDate(regDate);
                boardVo.setUserNo(userNo);
                boardVo.setGroupNo(groupNo);
                boardVo.setOrderNo(orderNo);
                boardVo.setDepth(depth);

                list.add(boardVo);
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
