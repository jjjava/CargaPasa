package org.pasa.sispasa.cargapasa.model;

/**
 *
 * @author Hudson Schumaker
 */
public class Estado {

    private String id;
    private String nome;
    private Pais pais;

    public Estado() {
        this.pais = new Pais(1L);
    }

    public Estado(String id) {
        this.pais = new Pais(1L);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
