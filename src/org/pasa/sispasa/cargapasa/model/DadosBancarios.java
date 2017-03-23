package org.pasa.sispasa.cargapasa.model;

import java.util.Date;
import org.pasa.sispasa.cargapasa.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class DadosBancarios {

    private Long id;
    private String codBanco;
    private String agencia;
    private String conta;
    private String tipoConta;
    private Long idUsuario;
    private Integer indAtivo;
    private Date dataUltimaAtualizacao;

    private DadosBancarios() {
        this.indAtivo = 1;
        this.idUsuario = 1L;
        this.dataUltimaAtualizacao = DateUtil.obterDataAtual();
    }

    private DadosBancarios(Long id) {
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

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(Integer indAtivo) {
        this.indAtivo = indAtivo;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
