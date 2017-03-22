package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.ConnectionSQLServer;
import org.pasa.sispasa.cargapasa.model.Pessoa;

/**
 *
 * @author Hudson Schumaker
 */
public class PessoaDAOImpl {

    private final Connection conn;

    public PessoaDAOImpl() {
        this.conn = ConnectionSQLServer.getConexao();
    }
    
    public Pessoa get(Long id){
        Pessoa pessoa = new Pessoa();
        String sql = "select * from pessoa where id_pessoa = "+id;
        
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pessoa.setId(rs.getLong("id_pessoa"));
                pessoa.setCpf("cpf");
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
        return pessoa;
    }
}
