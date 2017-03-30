package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Endereco;

/**
 *
 * @author Hudson Schumaker
 */
public class EnderecoDAOImpl {

    private final Connection conn;

    public EnderecoDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Long save(Endereco end) {
        Long id = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO ENDERECO ("
                    + "BAIRRO,"
                    + "CEP,"
                    + "DT_ULT_ATULZ,"
                    + "ID_USUARIO,"
                    + "IND_ATIVO,"
                    + "LOGRADOURO,"
                    + "ID_ESTADO,"
                    + "ID_MUNICIPIO) VALUES (?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, end.getBairro());
            ps.setString(2, end.getCep());
            ps.setDate(3, new java.sql.Date(end.getDataUltimaAtualizacao().getTime()));
            ps.setLong(4, end.getIdUsuario());
            ps.setInt(5, end.getIndAtivo());
            ps.setString(6, end.getLogradouro());
            ps.setString(7, end.getIdEstado());
            ps.setLong(8, end.getIdMunicipio());

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

        }
        return id;
    }
}
