
package org.pasa.sispasa.cargapasa.model;

/**
 *
 * @author Hudson Schumaker
 */
public class NivelEscolaridade {
    private Long id;
    private String descricao;
    private String codExterno;
    
    public NivelEscolaridade(){
    }
    
    public NivelEscolaridade(Long id){
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

    public String getCodExterno() {
        return codExterno;
    }

    public void setCodExterno(String codExterno) {
        this.codExterno = codExterno;
    }
}
