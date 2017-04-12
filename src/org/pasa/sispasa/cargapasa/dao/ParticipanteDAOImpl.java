package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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

    public Long getIdByNomeNomeMaeDataNascimento(String nome, String nomeMae, Date nascimento) {
        Long id = null;

        String sql = "select id_participante from participante where nome = ? and nm_mae = ?"+
                 " and dt_nascimento =?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, nomeMae);
            stmt.setDate(3,new java.sql.Date(nascimento.getTime()));
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getLong("ID_PARTICIPANTE");
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
