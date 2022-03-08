/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DINH
 */
public class ConnectionLib {
    
    Connection cn;

    public  Connection getConnectDB() throws SQLException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-B5E7GD1:1433;databaseName=Project_PRJ", "sa", "123456");
            System.out.println("OK");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cn;
    }

    public void close() {
        if (cn != null) {
            try {
                if (!cn.isClosed()) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        cn = null;
    }
}
