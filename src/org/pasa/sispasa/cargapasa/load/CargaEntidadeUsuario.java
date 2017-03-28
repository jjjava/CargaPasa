package org.pasa.sispasa.cargapasa.load;

import org.pasa.sispasa.cargapasa.model.UsuarioPlano;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaEntidadeUsuario {

    private UsuarioPlano usuarioPlano;

    public CargaEntidadeUsuario() {
    }

    public void newUsuarioPlano(TempBenPASA modeloBenef) {
        usuarioPlano = new UsuarioPlano();
        
    }

}
