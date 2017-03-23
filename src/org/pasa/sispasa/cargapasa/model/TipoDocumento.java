package org.pasa.sispasa.cargapasa.model;

/**
 *
 * @author Hudson Schumaker
 */
public class TipoDocumento {

    private Long id;
    private String descricao;

    public TipoDocumento() {
    }

    public TipoDocumento(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
