package org.pasa.sispasa.cargapasa.model;

import java.util.Date;
import org.pasa.sispasa.cargapasa.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class Telefone {

    private Long id;
    private String ddd;
    private String numeroTelefone;
    private String ramal;
    private Integer indAtivo;
    private Long idUsuario;
    private Date dataUltimaAtualizacao;
    private TipoTelefone tipoTelefone;

    public Telefone() {
        this.indAtivo = 1;
        this.dataUltimaAtualizacao = DateUtil.obterDataAtual();
    }

    public Telefone(Long id) {
        this.id = id;
        this.indAtivo = 1;
        this.dataUltimaAtualizacao = DateUtil.obterDataAtual();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public Integer getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(Integer indAtivo) {
        this.indAtivo = indAtivo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
