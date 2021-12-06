package test;

import com.example.user_case.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 17:49 2021/8/14
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
