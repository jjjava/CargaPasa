
package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.model.Pais;

/**
 *
 * @author Hudson Schumaker
 */
public class PaisDAOImpl {
    
    private final Connection conn;
    
    public PaisDAOImpl(){
        conn = SQLServerConnection.getConnectionPipe();
    }
    
    public Pais get(Long id){
        return null;
    }
}
