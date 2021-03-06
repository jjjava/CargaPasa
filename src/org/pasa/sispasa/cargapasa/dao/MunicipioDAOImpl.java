package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Municipio;

/**
 *
 * @author Hudson Schumaker
 */
public class MunicipioDAOImpl {

    private final Connection conn;

    public MunicipioDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Municipio get(Long id) {
        Municipio municipio = new Municipio();
        String sql = "select * from municipio where id_municipio = " + id;

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                municipio.setId(rs.getLong("id_municipio"));
                municipio.setNome(rs.getString("nome"));
                municipio.setIdEstado(rs.getString("id_estado"));
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
            return null;
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }

        }
        return municipio;
    }

    public Municipio get(String nome) {
        Municipio municipio = new Municipio();
        String sql = "select * from municipio where nome = '" + nome + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                municipio.setId(rs.getLong("id_municipio"));
                municipio.setNome(rs.getString("nome"));
                municipio.setIdEstado(rs.getString("id_estado"));
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
            return null;
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }

        }
        return municipio;
    }
}
