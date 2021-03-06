package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
public enum EnumTipoIntegracao {

    PEOPLE_SOFT_VALE_FPW(1L, "People Soft Vale/FPW"),
    PEOPLE_SOFT_VLI_FPW(2L, "People Soft VLI/FPW"),
    EXTERNA(3L, "Empresa externa");

    private final Long indice;
    private final String descricao;

    private EnumTipoIntegracao(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumTipoIntegracao getTipoIntegracaoByIndice(int indice) {
        switch (indice) {
            case 1:
                return EnumTipoIntegracao.PEOPLE_SOFT_VALE_FPW;
            case 2:
                return EnumTipoIntegracao.PEOPLE_SOFT_VLI_FPW;
            case 3:
                return EnumTipoIntegracao.EXTERNA;
            default:
                break;
        }
        return null;
    }

    //GETTERS E SETTERS
    public Long getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
