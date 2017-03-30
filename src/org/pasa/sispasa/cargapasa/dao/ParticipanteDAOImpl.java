package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Participante;

/**
 *
 * @author Hudson Schumaker
 */
public class ParticipanteDAOImpl {

    private final Connection conn;

    public ParticipanteDAOImpl() {
        conn = SQLServerConnection.getConnectionPipe();
    }

    public Long save(Participante modelo) {
        Long idRetornoParticipante = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO PARTICIPANTE ("
                    + " CPF"
                    + ",DT_NASCIMENTO"
                    + ",EMAIL_COMERCIAL"
                    + ",ID_USUARIO"
                    + ",IND_ATIVO"
                    + ",DT_ULT_ATULZ"
                    + ",IND_CONCL_ESCOL"
                    + ",NOME"
                    + ",NM_MAE"
                    + ",SEXO"
                    + ",ID_ENDERECO"
                    + ",ID_NIVEL_ESCOL"
                    + ",ID_ESTADO_CIVIL"
                    + ",ID_PAIS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, modelo.getCpf());
            ps.setDate(2, new java.sql.Date(modelo.getDataNascimento().getTime()));
            ps.setString(3, modelo.getEmail());
            ps.setLong(4, modelo.getIdUsuario());
            ps.setInt(5, modelo.getIndAtivo());
            ps.setDate(6, new java.sql.Date(modelo.getDataUltimaAtualizacao().getTime()));
            ps.setLong(7, modelo.getIndConclusaoEscolaridade());
            ps.setString(8, modelo.getNome());
            ps.setString(9, modelo.getNomeMae());
            ps.setString(10, modelo.getSexo());
            ps.setLong(11, modelo.getEndereco());
            ps.setLong(12, modelo.getNivelEscolaridade());
            ps.setLong(13, modelo.getEstadoCivil());
            ps.setLong(14, modelo.getNacionalidade());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idRetornoParticipante = rs.getLong(1);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
            return null;
        } finally {
        }
        return idRetornoParticipante;
    }
}
