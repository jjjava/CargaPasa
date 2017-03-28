
package org.pasa.sispasa.cargapasa.model;

import java.util.Date;

/**
 *
 * @author Hudson Schumaker
 */
public class Adesao {
    private Long idAdesaoPlano;
    private Long idUsuario;
    private Date dataInclusaoSistema;
    private Long idPlano;
    private Long idAssociado;
    
    public Adesao(){    
    }

    public Long getIdAdesaoPlano() {
        return idAdesaoPlano;
    }

    public void setIdAdesaoPlano(Long idAdesaoPlano) {
        this.idAdesaoPlano = idAdesaoPlano;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataInclusaoSistema() {
        return dataInclusaoSistema;
    }

    public void setDataInclusaoSistema(Date dataInclusaoSistema) {
        this.dataInclusaoSistema = dataInclusaoSistema;
    }

    public Long getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Long idPlano) {
        this.idPlano = idPlano;
    }

    public Long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(Long idAssociado) {
        this.idAssociado = idAssociado;
    }
    
    
    
    
    
}
