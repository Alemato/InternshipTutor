package controller.utility;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory extends HttpServlet {

    private static ConnectionFactory connectionFactory = null;

    public ConnectionFactory() {
        try {
            String driverClassName = "com.mysql.jdbc.Driver";
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {


        // cosi non usi il pooler di tomcat
        Connection conn = null;
        String connectionUrl = "jdbc:mysql://localhost:3306/student";
        String dbUser = "root";
        String dbPwd = "";
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}