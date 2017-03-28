package org.pasa.sispasa.cargapasa.run;

import org.pasa.sispasa.cargapasa.bean.MaestroCargaPasaBeanImpl;

/**
 *
 * @author Hudson Schumaker
 */
public class Start {

    public static void main(String args[]) {
        MaestroCargaPasaBeanImpl carga = new MaestroCargaPasaBeanImpl();
        carga.inicio();
    }
}
