package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                    + ",ID_TAXA_ASSOCIADO"
                    + ",ID_SITUACAO_ASSOCIADO"
                    + ",TP_ASSOCIADO"
                    + ",MATR_PASA"
                    + ",MATR_VALIA_PARTICIPANTE"
                    + ",MATR_VALIA_REPRESENTANTE"
                    + ",ID_USUARIO"
                    + ",DT_ULT_ATULZ"
                    + ",DT_ADMISSAO_GRUPO"
                    + ",TP_RESPONSAVEL_PAGAMENTO"
                    + ",CD_CATEGORIA_LEG"
                    + ",ID_FUNCIONARIO"
                    + ",DT_ASSOCIACAO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setLong(1, associado.getIdParticipante());
            ps.setLong(2, associado.getIdTaxaAssociado());
            ps.setLong(3, associado.getIdSituacaoAssociado());
            ps.setString(4, associado.getTipoAssociado());
            ps.setString(5, associado.getMatriculaPasa());
            ps.setString(6, associado.getMatriculaValiaParticipante());
            ps.setString(7, associado.getMatriculaValiaRepresentante());
            ps.setLong(8, associado.getIdUsuario());
            ps.setDate(9, new java.sql.Date(associado.getDataUltimaAlteracao().getTime()));
            ps.setDate(10, new java.sql.Date(associado.getDataAdmissaoGrupo().getTime()));
            ps.setString(11, associado.getTipoRespPagamento());
            ps.setString(12, associado.getCategoria());
            ps.setLong(13, associado.getIdFuncionario());
            ps.setDate(14, new java.sql.Date(associado.getDataAssociacao().getTime()));

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        }
    }

    public boolean verificaAssociadoByIdFunc(Long idFunc) {
        boolean existe = false;
        String sql = "select * from associado where associado.ID_FUNCIONARIO = " + idFunc + "";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                existe = true;
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
        return existe;
    }
}
