package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Documento;

/**
 *
 * @author Hudson Schumaker
 */
public class DocumentoDAOImpl {

    private final Connection conn;

    public DocumentoDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Long save(Documento doc) {
        Long id = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO DOCUMENTO ("
                    + "NUMERO,"
                    + "ID_USUARIO,"
                    + "IND_ATIVO,"
                    + "DT_ULT_ATULIZ,"
                    + "ID_TP_DOCUMENTO) VALUES (?,?,?,?,?)";

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, doc.getNumero());
            ps.setLong(2, doc.getIdUsuario());
            ps.setInt(3, doc.getIndAtivo());
            ps.setDate(4, new java.sql.Date(doc.getDataUltimaAtualizacao().getTime()));
            ps.setLong(5, doc.getTipoDocumento());
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(this.getClass().getName() + ":\n" + ex);
            }
        }
        return id;
    }
}
