package ysh.database.repository;

import lombok.extern.slf4j.Slf4j;
import ysh.database.connection.DBConnectionUtil;
import ysh.database.domain.Member;

import java.sql.*;

/**
 * JDBC - DriverManager 사용
 */
@Slf4j
public class MemberRepositoryV0 {

    public Member save(Member member) throws SQLException{
        String sql = "INSERT INTO MEMBER(MEMBER_ID, MONEY) VALUES(?, ?) ";
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate();
            return member;
        }catch(SQLException e){
            log.error("db error",e);
            throw e;
        }finally {
            close(con,pstmt,null);
        }
    }
    public Member findById(String memberId) throws SQLException{

    }

    private void close(Connection con, Statement stmt, ResultSet rs){
        if(stmt != null){
            try{
                stmt.close();
            }catch(SQLException e){
                log.info("error", e);
            }
        }
        if(con != null){
            try{
                con.close();
            }catch(SQLException e){
                log.info("error", e);
            }
        }
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                log.info("error", e);
            }
        }
    }


    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }

}