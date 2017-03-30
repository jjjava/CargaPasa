package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Hudson Schumaker
 */
public enum EnumCategoria {
    EMPREGADO("03", EnumTipoAssociado.A),
    DDE_COM_AMS("04", EnumTipoAssociado.E),
    RE_0587_0789("05", EnumTipoAssociado.E),
    TUTOR("06", EnumTipoAssociado.E),
    CURADOR_PENSIONISTA("07", EnumTipoAssociado.E),
    CURADOR_APOSENTADO("08", EnumTipoAssociado.E),
    PENSIONISTA_AMS_RE_05_87_07_89("09", EnumTipoAssociado.E),
    APOSENTADO_COM_DDE_E_AMS("10", EnumTipoAssociado.E),
    PENSIONISTA_COM_AMS_SUMAN_010_90("13", EnumTipoAssociado.E),
    ADIDO_CEDIDO_FOPAG("15", EnumTipoAssociado.A),
    APOSENTADO_INVALIDEZ_SUMAN_10_90("19", EnumTipoAssociado.E),
    ADIDO_CEDIDO_BANCO("29", EnumTipoAssociado.E),
    ADIDO_CEDIDO_CAIXA("21", EnumTipoAssociado.E),
    APOSENTADO_INSS_C_AMS("22", EnumTipoAssociado.E),
    ASSOCIADO_NAO_CONTRIBUINTE("23", EnumTipoAssociado.A),
    CATEGORIA_ESPECIAL("29", EnumTipoAssociado.E),
    ACORDO_03_2015("36", EnumTipoAssociado.E),
    CATEGORIA_ESPECIAL_ODONTO("39", EnumTipoAssociado.E);

    private final String codLegado;
    private final EnumTipoAssociado descricao;

    EnumCategoria(String codLegado, EnumTipoAssociado descricao) {
        this.codLegado = codLegado;
        this.descricao = descricao;
    }

    public static  boolean isAtivo(String extCod) {
        for (EnumCategoria c : EnumCategoria.values()) {
            if (extCod.equalsIgnoreCase(c.getCodLegado())) {
                return true;
            }
        }
        return false;
    }

    public String getCodLegado() {
        return codLegado;
    }

    public String getDescricao() {
        return descricao.getDescricao();
    }
}
