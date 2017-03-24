package org.pasa.sispasa.cargapasa.run;

import org.pasa.sispasa.cargapasa.bean.CargaPasaBeanImpl;

/**
 *
 * @author Hudson Schumaker
 */
public class Start {

    public static void main(String args[]) {
        CargaPasaBeanImpl carga = new CargaPasaBeanImpl();
        carga.inicio();
    }
}
