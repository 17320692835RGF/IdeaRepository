package test;

import com.neuedu.hebeigc_usercase.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 10:37 2021/8/30
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
    }
}
