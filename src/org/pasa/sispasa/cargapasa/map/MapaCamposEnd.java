package org.pasa.sispasa.cargapasa.map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hudson Schumaker
 */
public class MapaCamposEnd {

    private final Map<String, PosicaoCampo> mapa;

    public MapaCamposEnd() {
        mapa = new HashMap<>();
        mapa.put(MapaCampos.EMPRESA, new PosicaoCampo(1, 3));
        mapa.put(MapaCampos.MATRICULA, new PosicaoCampo(3, 9));
        mapa.put(MapaCampos.COD_BENEFICIARIO, new PosicaoCampo(9, 11));
        
        mapa.put(MapaCampos.TELEFONE1, new PosicaoCampo(11, 25));
        mapa.put(MapaCampos.TELEFONE2, new PosicaoCampo(26, 40));
        mapa.put(MapaCampos.TELEFONE3, new PosicaoCampo(41, 55));
        
        mapa.put(MapaCampos.ENDERECO, new PosicaoCampo(58, 105));
        mapa.put(MapaCampos.BAIRRO,new PosicaoCampo(106, 135));
        mapa.put(MapaCampos.CIDADE, new PosicaoCampo(136, 170));
        mapa.put(MapaCampos.UF, new PosicaoCampo(170, 172));
        mapa.put(MapaCampos.CEP, new PosicaoCampo(172, 180));
        mapa.put(MapaCampos.EMAIL, new PosicaoCampo(180, 215));
    }

    public Map<String, PosicaoCampo> getMapa() {
        return mapa;
    }
}