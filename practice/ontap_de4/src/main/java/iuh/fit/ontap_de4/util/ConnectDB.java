package iuh.fit.ontap_de4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL ="jdbc:mysql://localhost:3306/QLSukienThethao";
    private static final String USER = "phuc";
    private static final String PASS = "123456";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
