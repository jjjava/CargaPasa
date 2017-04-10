
package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.UsuarioPlano;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;

/**
 *
 * @author Hudson Schumaker
 */
public class UsuarioPlanoDAOImpl {

    private final Connection conn;

    public UsuarioPlanoDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Long save(UsuarioPlano up) {
        Long id = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO USUARIO_PLANO ("
                    + "IND_TITULAR_RESPONSAVEL_PAG"
                    + ",ID_PARTICIPANTE"
                    + ",ID_ADESAO_PLANO"
                    + ",ID_USUARIO_TITULAR_PLANO"
                    + ",ID_TP_USUARIO"
                    + ",ID_GRAU_PARENT"
                    + ",STATUS_USUARIO"
                    + ",DT_INCLUSAO_SISTEMA"
                    + ",ID_USUARIO) VALUES (?,?,?,?,?,?,?,?,?)";
            
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, up.getIndTitularResponsavelPagamento());
            ps.setLong(2, up.getIdParticipante());
            ps.setLong(3, up.getIdAdesaoPlano());
            ps.setLong(4, up.getIdUsuarioTitularPlano());
            ps.setLong(5, up.getIdTipoUsario());
            ps.setLong(6, up.getIdGrauParentesco());
            ps.setInt(7, up.getStatusUsuario());
            ps.setDate(8, new java.sql.Date(up.getDataInclusaoSistema().getTime()));
            ps.setLong(9, CargaPasaCommon.USER_CARGA);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);//
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        }
        return id;
    }
}
