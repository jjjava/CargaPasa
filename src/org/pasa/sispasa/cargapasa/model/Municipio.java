package org.pasa.sispasa.cargapasa.model;

/**
 *
 * @author Hudson Schumaker
 */
public class Municipio {

    private Long id;
    private String nome;
    private String idEstado;

    public Municipio() {
    }

    public Municipio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }
}
