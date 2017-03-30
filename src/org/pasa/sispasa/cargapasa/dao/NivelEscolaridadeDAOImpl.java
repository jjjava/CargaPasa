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
public class NivelEscolaridadeDAOImpl {

    private final Connection conn;

    public NivelEscolaridadeDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Long get(String cod) {
        Long id = null;
        if(cod.equalsIgnoreCase("")){
            cod = "0";
        }
        String sql = "select * from nivel_escolaridade where cd_externo = '" + cod + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getLong("id_nivel_escol");
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            return null;
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
        }
        return id;
    }
}
