package org.pasa.sispasa.cargapasa.model;

import java.util.Date;

/**
 *
 * @author Hudson Schumaker
 */
public class UsuarioPlano {

    private Long idUsuarioPlano;
    private Integer indTitularResponsavelPagamento;
    private Long idUsuario;
    private Date dataInclusaoSistema;
    private Integer statusUsuario;
    private Long idParticipante;
    private Long idAdesaoPlano;
    private Long idUsuarioTitularPlano;
    private Long idTipoUsario;
    private Long idGrauParentesco;
    private Long idVinculo;
    private String carteirinha;
    
    public UsuarioPlano(){
    }

    public Long getIdUsuarioPlano() {
        return idUsuarioPlano;
    }

    public void setIdUsuarioPlano(Long idUsuarioPlano) {
        this.idUsuarioPlano = idUsuarioPlano;
    }

    public Integer getIndTitularResponsavelPagamento() {
        return indTitularResponsavelPagamento;
    }

    public void setIndTitularResponsavelPagamento(Integer indTitularResponsavelPagamento) {
        this.indTitularResponsavelPagamento = indTitularResponsavelPagamento;
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

    public Integer getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(Integer statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public Long getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Long idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Long getIdAdesaoPlano() {
        return idAdesaoPlano;
    }

    public void setIdAdesaoPlano(Long idAdesaoPlano) {
        this.idAdesaoPlano = idAdesaoPlano;
    }

    public Long getIdUsuarioTitularPlano() {
        return idUsuarioTitularPlano;
    }

    public void setIdUsuarioTitularPlano(Long idUsuarioTitularPlano) {
        this.idUsuarioTitularPlano = idUsuarioTitularPlano;
    }

    public Long getIdTipoUsario() {
        return idTipoUsario;
    }

    public void setIdTipoUsario(Long idTipoUsario) {
        this.idTipoUsario = idTipoUsario;
    }

    public Long getIdGrauParentesco() {
        return idGrauParentesco;
    }

    public void setIdGrauParentesco(Long idGrauParentesco) {
        this.idGrauParentesco = idGrauParentesco;
    }

    public Long getIdVinculo() {
        return idVinculo;
    }

    public void setIdVinculo(Long idVinculo) {
        this.idVinculo = idVinculo;
    }
    
    public String getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(String carteirinha) {
        this.carteirinha = carteirinha;
    }
}
