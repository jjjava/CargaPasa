package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumTipoVinculoEmpregaticio {

    Estagiario(0L, "Estagiário"),
    MenorAprendiz(1L, "Menor aprendiz"),
    TrabalahdorTemporario(2L, "Trabalhador temporario"),
    EmpregadoAtivo(3L, "Empregado ativo"),
    Aposentado(4L, "Aposentado"),
    Pensionista(5L, "Pensionista"),
    ExEmpregado(6L, "Ex-Empregado");

    private final Long indice;
    private final String descricao;

    private EnumTipoVinculoEmpregaticio(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public Long getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
