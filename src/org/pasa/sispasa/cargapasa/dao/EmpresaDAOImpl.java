package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.ConnectionSQLServer;
import org.pasa.sispasa.cargapasa.model.Empresa;

/**
 *
 * @author Hudson Schumaker
 */
public class EmpresaDAOImpl {

    private final Connection conn;

    public EmpresaDAOImpl() {
        conn = ConnectionSQLServer.getConexao();
    }

    public Empresa get(Long id) {
        Empresa empresa = new Empresa();
        String sql = "select id_empresa,cd_empresa_vale from emprea where id_empresa = "+id;
        
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
            System.err.println(ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
        }
        return empresa;
    }
    
    public Empresa get(String cod){
        Empresa empresa = new Empresa();
        String sql = "select id_empresa,cd_empresa_vale from emprea where cd_empresa_vale = '"+cod+"'";
        
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
            System.err.println(ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
        }
        return empresa;
    }
}