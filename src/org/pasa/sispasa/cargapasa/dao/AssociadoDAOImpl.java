package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Associado;

/**
 *
 * @author Hudson Schumaker
 */
public class AssociadoDAOImpl {

    private final Connection conn;

    public AssociadoDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public void salve(Associado associado) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO ASSOCIADO ("
                    + " ID_PARTICIPANTE"
                    + ",ID_FUNCIONARIO"
                    + ",ID_TAXA_ASSOCIADO"
                    + ",ID_SITUACAO_ASSOCIADO"
                    + ",TP_ASSOCIADO"
                    + ",MATR_PASA"
                    + ",MATR_VALIA_PARTICIPANTE"
                    + ",MATR_VALIA_REPRESENTANTE"
                    + ",ID_USUARIO"
                    + ",DT_ULT_ATULZ"
                    + ",DT_ADMISSAO_GRUPO) VALUES (?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setLong(1, associado.getIdParticipante());
            ps.setLong(2, associado.getIdFuncionario());
            ps.setLong(3, associado.getIdTaxaAssociado());
            ps.setLong(4, associado.getIdSituacaoAssociado());
            ps.setLong(5, associado.getTipoAssociado());
            ps.setString(6, associado.getMatriculaPasa());
            ps.setString(7, associado.getMatriculaValiaParticipante());
            ps.setString(8, associado.getMatriculaValiaRepresentante());
            ps.setLong(9, associado.getIdUsuario());
            ps.setDate(10, new java.sql.Date(associado.getDataUltimaAlteracao().getTime()));
            ps.setDate(11, new java.sql.Date(associado.getDataAdmissaoGrupo().getTime()));

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        }
    }
}
