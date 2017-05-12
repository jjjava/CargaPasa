package org.pasa.sispasa.cargapasa.bean;

import java.util.List;
import org.pasa.sispasa.cargapasa.dao.TempBenPasaDAOImpl;
import org.pasa.sispasa.cargapasa.load.TempBenPASA;

/**
 *
 * @author Hudson Schumaker
 */
public class TempBenPasaBeanImpl {

    private final TempBenPasaDAOImpl dao;

    /*
    *
    * Construtor
    */
    public TempBenPasaBeanImpl() {
        this.dao = new TempBenPasaDAOImpl();
    }

    /*
    * @param TempBenPASA modelo
    * @return void
    */
    public void save(TempBenPASA modelo) {
        this.dao.save(modelo);
    }
    
    /*
    * @return void
    */
    public void closeConnection(){
        this.dao.closeConnection();
    }

    
    /*
    * @param List<TempBenPASA> modelo
    * @return void
    */
    public void save(List<TempBenPASA> modelo) {
        for (TempBenPASA m : modelo) {
            this.dao.save(m);
        }
    }
}
