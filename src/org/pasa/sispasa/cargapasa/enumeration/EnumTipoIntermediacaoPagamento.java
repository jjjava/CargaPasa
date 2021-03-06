package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumTipoIntermediacaoPagamento {

    NotaDebito(0, "Nota de débito"),
    DescontoFolha(1, "Desconto em folha"),
    Patrocinio(2, "Patrocinio");

    private final int indice;
    private final String descricao;

    private EnumTipoIntermediacaoPagamento(int indice, String descricao) {
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
