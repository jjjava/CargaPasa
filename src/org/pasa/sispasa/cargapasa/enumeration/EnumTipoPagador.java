package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumTipoPagador {

    EMPRESA("E", "Empresa"),
    USUARIO("U", "Usuario"),
    TODOS("T", "Todos");

    private final String indice;
    private final String descricao;

    private EnumTipoPagador(String indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public String getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
