package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumTipoVinculoBeneficio {

    Titular(0, "Titular"),
    Dependente(1, "Dependente"),
    Agregado(2, "Agregado");

    private final int indice;
    private final String descricao;

    private EnumTipoVinculoBeneficio(int indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public int getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
