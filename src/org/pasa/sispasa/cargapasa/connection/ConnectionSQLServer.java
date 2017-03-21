package org.pasa.sispasa.cargapasa.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hudson Schumaker
 */
public class ConnectionSQLServer {

    public ConnectionSQLServer() {
    }

    public static Connection getConexao() {
        Connection conn = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
        try {
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://PASA-WKS-PA103:1433;instance=PASA;DatabaseName=sispasa;",
                    "pasa", "pasa");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return conn;
    }
}
