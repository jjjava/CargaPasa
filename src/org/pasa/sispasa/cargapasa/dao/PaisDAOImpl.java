
package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import org.pasa.sispasa.cargapasa.connection.ConnectionSQLServer;
import org.pasa.sispasa.cargapasa.model.Pais;

/**
 *
 * @author Hudson Schumaker
 */
public class PaisDAOImpl {
    
    private final Connection conn;
    
    public PaisDAOImpl(){
        conn = ConnectionSQLServer.getConexao();
    }
    
    public Pais get(Long id){
        return null;
    }
}
