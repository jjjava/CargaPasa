package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.AdesaoUsuario;

/**
 *
 * @author Hudson Schumaker
 */
public class AdesaoPlanoDAOImpl {

    private static final Logger LOGGER = Logger.getLogger(AdesaoPlanoDAOImpl.class);
    private final Connection conn;
    
    /**
     * 
     * Construtor
     */
    public AdesaoPlanoDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }

    public Long save(AdesaoUsuario adesao) {
        Long id = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO ADESAO_PLANO ("
                    + " ID_PLANO"
                    + ",ID_ASSOCIADO"
                    + ",ID_USUARIO"
                    + ",DT_INCLUSAO_SISTEMA) VALUES (?,?,?,?)";
            
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, adesao.getIdPlano());
            ps.setLong(2, adesao.getIdAssociado());
            ps.setLong(3, adesao.getIdUsuario());
            ps.setDate(4, new java.sql.Date(adesao.getDataInclusaoSistema().getTime()));
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        return id;
    }
}
