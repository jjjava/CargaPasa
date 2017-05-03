
package org.pasa.sispasa.cargapasa.model;

import java.util.Date;

/**
 *
 * @author Hudson Schumaker
 */
public class AdesaoUsuarioPlano {
    private Long idAdesaoPlano;
    private Date dataUltimaAtulizacao;
    private Long idUsuario;
    private Long idPlano;
    
    public AdesaoUsuarioPlano(){
    }

    public Long getIdAdesaoPlano() {
        return idAdesaoPlano;
    }

    public void setIdAdesaoPlano(Long idAdesaoPlano) {
        this.idAdesaoPlano = idAdesaoPlano;
    }

    public Date getDataUltimaAtulizacao() {
        return dataUltimaAtulizacao;
    }

    public void setDataUltimaAtulizacao(Date dataUltimaAtulizacao) {
        this.dataUltimaAtulizacao = dataUltimaAtulizacao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Long idPlano) {
        this.idPlano = idPlano;
    }
}
