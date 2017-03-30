package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Telefone;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;

/**
 *
 * @author Hudson Schumaker
 */
public class TelefoneDAOImpl {

    private final Connection conn;

    public TelefoneDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Long save(Telefone tel) {
        Long id = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO TELEFONE ("
                + "DT_ULT_ATULZ"
                + ",ID_USUARIO"
                + ",IND_ATIVO"
                + ",NUMERO) VALUES(?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, new java.sql.Date(tel.getDataUltimaAtualizacao().getTime()));
            ps.setLong(2, CargaPasaCommon.USER_CARGA);
            ps.setLong(3, CargaPasaCommon.ATIVO);
            ps.setString(4, tel.getNumeroTelefone());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            return null;
        } finally {
           
        }
        return id;
    }

    public void linkParticipanteTelefone(Long idParticipante, Long idTelefone) {
        PreparedStatement ps = null;
        String sql = "INSERT INTO PARTICIPANTE_TELEFONE ( "
                + "ID_PARTICIPANTE"
                + ",ID_TELEFONE) VALUES(?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, idParticipante);
            ps.setLong(2, idTelefone);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        } finally {
           
        }
    }
}
