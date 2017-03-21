package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Allan Garcia
 *
 */
public enum EnumTipoEnvioCobranca {

    E("Email"),
    C("Correios");

    private final String descricao;

    private EnumTipoEnvioCobranca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
