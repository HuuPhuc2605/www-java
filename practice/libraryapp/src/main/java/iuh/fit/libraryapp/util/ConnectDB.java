package iuh.fit.libraryapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:mysql://localhost:3306/qlthuvien";
    private static final String USER = "phuc";
    private static final String PASS = "123456";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER, PASS);
    }
}
