package database;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/test?autoReconnect=true&serverTimezone=UTC";
    private final static String USER_NAME = "new_user";
    private final static String PASSWORD = null;
    private final static String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }


    private static DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(DATASOURCE_DRIVER);
        dataSource.setJdbcUrl(JDBC_URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }
}
