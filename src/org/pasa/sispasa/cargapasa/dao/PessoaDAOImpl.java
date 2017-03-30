package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Pessoa;

/**
 *
 * @author Hudson Schumaker
 */
public class PessoaDAOImpl {

    private final Connection conn;

    public PessoaDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Pessoa get(Long id) {
        Pessoa pessoa = new Pessoa();
        String sql = "select * from pessoa where id_pessoa = " + id;

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
            System.err.println(this.getClass().getName() + ":\n" + ex);
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
        return pessoa;
    }

    public Pessoa get(String cpf) {
        Pessoa pessoa = new Pessoa();
        String sql = "select * from pessoa where cpf = '" + cpf + "'";

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
            System.err.println(this.getClass().getName() + ":\n" + ex);
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
        return pessoa;
    }

    public Long getID(String cpf) {
        Long id = null;
        String sql = "select pessoa.id_pessoa from pessoa where pessoa.cpf = '" + cpf + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = (rs.getLong("id_pessoa"));
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
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
        return id;
    }

    public Long getIdByNome(String nome) {
        Long id = null;
        String sql = "select pessoa.id_pessoa from pessoa where pessoa.nome = '" + nome + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = (rs.getLong("id_pessoa"));
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
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
        return id;
    }
}
