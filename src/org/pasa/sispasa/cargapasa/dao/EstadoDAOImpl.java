package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Estado;

/**
 *
 * @author Hudson Schumaker
 */
public class EstadoDAOImpl {

    private static final Logger LOGGER = Logger.getLogger(EstadoDAOImpl.class);
    private final Connection conn;

    /*
    * Construtor
     */
    public EstadoDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Estado get(String uf) {
        Estado estado = new Estado();
        String sql = "select * from estado where id_estado = '" + uf + "'";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                estado.setId(rs.getString("id_estado"));
                estado.setNome("nome");
            }
        } catch (SQLException ex) {
            LOGGER.error(ex);
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
                    LOGGER.error(ex);
                }
            }
        }
        return estado;
    }
}
