package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Empresa;
import org.pasa.sispasa.cargapasa.model.Funcionario;
import org.pasa.sispasa.cargapasa.model.Pessoa;

/**
 *
 * @author Hudson Schumaker
 */
public class FuncionarioDAOImpl {

    private final Connection conn;
    private final EmpresaDAOImpl empresaDAO;

    public FuncionarioDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
        this.empresaDAO = new EmpresaDAOImpl();
    }

    public Long getId(Long idPessoa) {
        Long id = null;
        String sql = "select * from funcionario where funcionario.id_pessoa = " + idPessoa;

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getLong("ID_FUNCIONARIO");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
                }
            }
        }
        return id;
    }

    public Long getIdByMatriculaOrgiem(String matOrigem, String empresa) {
        String aux = "0" + matOrigem;
        return getId(empresaDAO.get(empresa).getId(), aux);
    }

    public Long getId(Long empresa, String matricula) {
        Long id = null;
        String sql = "select * from funcionario where id_empresa = " + empresa + " and MATR_ORIGEM = '" + matricula + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getLong("id_funcionario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
                }
            }
        }
        return id;
    }

    public Funcionario get(Long empresa, String matricula) {
        Funcionario funcionario = new Funcionario();
        String sql = "select * from funcionario where id_empresa = " + empresa + " and MATR_ORIGEM = '" + matricula + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                funcionario.setId(rs.getLong("id_funcionario"));
                funcionario.setEmpresa(new Empresa(rs.getLong("id_empresa")));
                funcionario.setMatriculaOrigem(rs.getString("MATR_ORIGEM"));
                funcionario.setPessoa(new Pessoa(rs.getLong("id_pessoa")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
                }
            }
        }
        return funcionario;
    }

}
