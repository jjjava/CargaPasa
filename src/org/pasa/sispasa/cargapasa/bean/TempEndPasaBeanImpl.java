package org.pasa.sispasa.cargapasa.bean;

import org.pasa.sispasa.cargapasa.dao.TempEndPasaDAOImpl;
import org.pasa.sispasa.cargapasa.model.TempEndPASA;

/**
 *
 * @author Hudson Schumaker
 */
public class TempEndPasaBeanImpl {

    private final TempEndPasaDAOImpl dao;

    public TempEndPasaBeanImpl() {
        dao = new TempEndPasaDAOImpl();
    }
    
    public void save(TempEndPASA modelo){
        dao.save(modelo);
    }
}
