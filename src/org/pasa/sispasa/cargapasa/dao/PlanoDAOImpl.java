package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;

/**
 *
 * @author Hudson Schumaker
 */
public class PlanoDAOImpl {

    private final Connection conn;

    public PlanoDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Long getId(String extCod) {
        Long id = null;
        String sql = "SELECT * FROM PLANO WHERE cd_plano = '" + extCod + "'";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getLong("id_plano");
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + "\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + "\n" + ex);
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + "\n" + ex);
                }
            }
        }
        return id;
    }
}
