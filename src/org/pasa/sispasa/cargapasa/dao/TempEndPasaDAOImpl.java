package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.map.MapaCampos;
import org.pasa.sispasa.cargapasa.load.TempEndPASA;

/**
 *
 * @author Hudson Schumaker
 */
public class TempEndPasaDAOImpl {

    private final Connection conn;

    public TempEndPasaDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public TempEndPASA get(Long id) {
        TempEndPASA modelo = new TempEndPASA();
        String sql = "select * from TB_TEMP_END_PASA where id = " + id;

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setTelefone1(rs.getString("telefone1"));
                modelo.setTelefone2(rs.getString("telefone2"));
                modelo.setTelefone3(rs.getString("telefone3"));
                modelo.setEndereco(rs.getString("endereco"));
                modelo.setBairro(rs.getString("bairro"));
                modelo.setCidade(rs.getString("cidade"));
                modelo.setUf(rs.getString("uf"));
                modelo.setCep(rs.getString("cep"));
                modelo.setEmail(rs.getString("email"));
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
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelo;
    }

    public TempEndPASA get(String empresa, String matricula) {
        TempEndPASA modelo = new TempEndPASA();
        String sql = "select * from TB_TEMP_END_PASA where empresa = '" + empresa
                + "' and matricula ='" + matricula + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setTelefone1(rs.getString("telefone1"));
                modelo.setTelefone2(rs.getString("telefone2"));
                modelo.setTelefone3(rs.getString("telefone3"));
                modelo.setEndereco(rs.getString("endereco"));
                modelo.setBairro(rs.getString("bairro"));
                modelo.setCidade(rs.getString("cidade"));
                modelo.setUf(rs.getString("uf"));
                modelo.setCep(rs.getString("cep"));
                modelo.setEmail(rs.getString("email"));
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
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelo;
    }

    public TempEndPASA get(String empresa, String matricula, String cdBenef) {
        TempEndPASA modelo = new TempEndPASA();
        String sql = "select * from TB_TEMP_END_PASA where empresa = '" + empresa
                + "' and matricula ='" + matricula + "' and cod_beneficiario = '" + cdBenef + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setTelefone1(rs.getString("telefone1"));
                modelo.setTelefone2(rs.getString("telefone2"));
                modelo.setTelefone3(rs.getString("telefone3"));
                modelo.setEndereco(rs.getString("endereco"));
                modelo.setBairro(rs.getString("bairro"));
                modelo.setCidade(rs.getString("cidade"));
                modelo.setUf(rs.getString("uf"));
                modelo.setCep(rs.getString("cep"));
                modelo.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
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
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelo;
    }

    public void save(TempEndPASA modelo) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO TB_TEMP_END_PASA ( "
                    + MapaCampos.EMPRESA
                    + "," + MapaCampos.MATRICULA
                    + "," + MapaCampos.COD_BENEFICIARIO
                    + "," + MapaCampos.TELEFONE1
                    + "," + MapaCampos.TELEFONE2
                    + "," + MapaCampos.TELEFONE3
                    + "," + MapaCampos.ENDERECO
                    + "," + MapaCampos.BAIRRO
                    + "," + MapaCampos.CIDADE
                    + "," + MapaCampos.UF
                    + "," + MapaCampos.CEP
                    + "," + MapaCampos.EMAIL
                    + " ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, modelo.getEmpresa());
            ps.setString(2, modelo.getMatricula());
            ps.setString(3, modelo.getCodBeneficiario());
            ps.setString(4, modelo.getTelefone1());
            ps.setString(5, modelo.getTelefone2());
            ps.setString(6, modelo.getTelefone3());
            ps.setString(7, modelo.getEndereco());
            ps.setString(8, modelo.getBairro());
            ps.setString(9, modelo.getCidade());
            ps.setString(10, modelo.getUf());
            ps.setString(11, modelo.getCep());
            ps.setString(12, modelo.getEmail());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.err.println(this.getClass().getName() + ":\n" + ex);
            }
        }
    }

    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        }
    }
}
