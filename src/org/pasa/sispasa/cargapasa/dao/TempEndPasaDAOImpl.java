package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.pasa.sispasa.cargapasa.connection.ConnectionSQLServer;
import org.pasa.sispasa.cargapasa.map.MapaCampos;
import org.pasa.sispasa.cargapasa.model.TempEndPASA;

/**
 *
 * @author Hudson Schumaker
 */
public class TempEndPasaDAOImpl {

    private final Connection conn;

    public TempEndPasaDAOImpl() {
        this.conn = ConnectionSQLServer.getConexao();
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
            System.err.println(ex);
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
}
