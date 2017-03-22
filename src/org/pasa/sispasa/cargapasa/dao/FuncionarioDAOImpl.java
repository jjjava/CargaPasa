package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.ConnectionSQLServer;
import org.pasa.sispasa.cargapasa.model.Empresa;
import org.pasa.sispasa.cargapasa.model.Funcionario;
import org.pasa.sispasa.cargapasa.model.Pessoa;

/**
 *
 * @author Hudson Schumaker
 */
public class FuncionarioDAOImpl {

    private final Connection conn;

    public FuncionarioDAOImpl() {
        this.conn = ConnectionSQLServer.getConexao();
    }

    public Funcionario get(Long empresa, String matricula) {
        Funcionario funcionario = new Funcionario();
        String sql = "select * from emprea where id_empresa = " + empresa + " and matr_origem = '" + matricula + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                funcionario.setId(rs.getLong("id_funcionario"));
                funcionario.setEmpresa(new Empresa(rs.getLong("id_empresa")));
                funcionario.setMatriculaOrigem(rs.getString("matr_origem"));
                funcionario.setPessoa(new Pessoa(rs.getLong("id_pessoa")));
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
        return funcionario;
    }

}
