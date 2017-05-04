
package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.AdesaoUsuarioPlano;

/**
 *
 * @author Hudson Schumaker
 */
public class AdesaoUsuarioPlanoDAOImpl {
    
    private final Connection conn;
    private final static Logger LOGGER = Logger.getLogger(AdesaoUsuarioPlanoDAOImpl.class);

    public AdesaoUsuarioPlanoDAOImpl() {
        this.conn = SQLServerConnection.getConnectionPipe();
    }
    
    public void save(AdesaoUsuarioPlano aup){
         PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO ADESAO_PLANO ("
                    + " ID_ADESAO_PLANO"
                    + ",ID_USUARIO"
                    + ",ID_PLANO"
                    + ",DT_ULT_ATULZ) VALUES (?,?,?,?)";
            
            ps = conn.prepareStatement(sql);
            
            ps.setLong(1, aup.getIdAdesaoPlano());
            ps.setLong(2,aup.getIdUsuario());
            ps.setLong(3, aup.getIdPlano());
            ps.setDate(4, new java.sql.Date(aup.getDataUltimaAtulizacao().getTime()));//ponto de atencao 
            
            ps.executeUpdate();
           
            ps.close();
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }    
    }
}
