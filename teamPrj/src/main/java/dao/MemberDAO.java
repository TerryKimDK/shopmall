package dao;

import lombok.RequiredArgsConstructor;
import model.MemberDTO;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    static Connection conn = null;
    static PreparedStatement stmt = null;
    static ResultSet rs = null;
    private final HikariDataSource dataSource;

    public int selectCount(MemberDTO member) {
        int count = 0;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("select  count(id) from member where id=? and password=?");
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getPassword());
            rs = stmt.executeQuery();

            if (rs.next())
                count = rs.getInt(1);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return count;
    }

    private static void close() {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
