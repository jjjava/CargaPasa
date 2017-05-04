package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Empresa;

/**
 *
 * @author Hudson Schumaker
 */
public class EmpresaDAOImpl {

    private final static Logger LOGGER = Logger.getLogger(EmpresaDAOImpl.class);
    private final Connection conn;

    /*
    *
    * Construtor
     */
    public EmpresaDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Empresa get(Long id) {
        Empresa empresa = new Empresa();
        String sql = "select id_empresa,cd_empresa_vale from empresa where id_empresa = " + id;

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                empresa.setId(rs.getLong("id_empresa"));
                empresa.setCodEmpresaVale("cd_empresa_vale");
            }
        } catch (SQLException ex) {
            LOGGER.error(ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex);
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
        return empresa;
    }

    public Empresa get(String cod) {
        Empresa empresa = new Empresa();
        String sql = "select id_empresa,cd_empresa_vale from empresa where cd_empresa_vale = '" + cod + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                empresa.setId(rs.getLong("id_empresa"));
                empresa.setCodEmpresaVale("cd_empresa_vale");
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex);
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
        return empresa;
    }

    public Long getByCdVale(String cod) {
        Long id = null;
        String sql = "select id_empresa,cd_empresa_vale from empresa where cd_empresa_vale = '" + cod + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getLong("id_empresa");
            }
        } catch (SQLException ex) {
            LOGGER.error(ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex);
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
        return id;
    }
}
