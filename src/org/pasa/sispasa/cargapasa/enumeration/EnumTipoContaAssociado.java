package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumTipoContaAssociado {

    P("Pagamento"),
    R("Reembolso");

    private final String descricao;

    private EnumTipoContaAssociado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
