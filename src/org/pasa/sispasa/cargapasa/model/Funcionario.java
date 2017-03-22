
package org.pasa.sispasa.cargapasa.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public class Funcionario {
    
    private Long id;
    private String matriculaOrigem;
    private String matriculaPasa;
    private String empresaAtualizadora;
    private String matriculaAtualizadora;
    private String direitoAbaterIR;
    private Date dataAdmissao;
    private Date dataDesligamento;
    private String emailCorporativo;
    private String financeira;
    private String contratoTrabalho;
    private String codDireitoPasa;
    private String unidadeControle;
    private String centroCusto;
    private String codFilialVLI;
    private Long idUsuario;
    private Integer indAtivo;
    private Date dataUltimaAtualizacao;
    private Empresa empresa;
    private TipoVinculoEmpregaticio tipoVinculoEmpregaticio;
    private DadosBancarios dadosBancarios;
    private MotivoDesligamento motivoDesligamento;
    private List<Beneficiario> beneficiarios;
    private Pessoa pessoa;
    
    public Funcionario(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriculaOrigem() {
        return matriculaOrigem;
    }

    public void setMatriculaOrigem(String matriculaOrigem) {
        this.matriculaOrigem = matriculaOrigem;
    }

    public String getMatriculaPasa() {
        return matriculaPasa;
    }

    public void setMatriculaPasa(String matriculaPasa) {
        this.matriculaPasa = matriculaPasa;
    }

    public String getEmpresaAtualizadora() {
        return empresaAtualizadora;
    }

    public void setEmpresaAtualizadora(String empresaAtualizadora) {
        this.empresaAtualizadora = empresaAtualizadora;
    }

    public String getMatriculaAtualizadora() {
        return matriculaAtualizadora;
    }

    public void setMatriculaAtualizadora(String matriculaAtualizadora) {
        this.matriculaAtualizadora = matriculaAtualizadora;
    }

    public String getDireitoAbaterIR() {
        return direitoAbaterIR;
    }

    public void setDireitoAbaterIR(String direitoAbaterIR) {
        this.direitoAbaterIR = direitoAbaterIR;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public String getFinanceira() {
        return financeira;
    }

    public void setFinanceira(String financeira) {
        this.financeira = financeira;
    }

    public String getContratoTrabalho() {
        return contratoTrabalho;
    }

    public void setContratoTrabalho(String contratoTrabalho) {
        this.contratoTrabalho = contratoTrabalho;
    }

    public String getCodDireitoPasa() {
        return codDireitoPasa;
    }

    public void setCodDireitoPasa(String codDireitoPasa) {
        this.codDireitoPasa = codDireitoPasa;
    }

    public String getUnidadeControle() {
        return unidadeControle;
    }

    public void setUnidadeControle(String unidadeControle) {
        this.unidadeControle = unidadeControle;
    }

    public String getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(String centroCusto) {
        this.centroCusto = centroCusto;
    }

    public String getCodFilialVLI() {
        return codFilialVLI;
    }

    public void setCodFilialVLI(String codFilialVLI) {
        this.codFilialVLI = codFilialVLI;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoVinculoEmpregaticio getTipoVinculoEmpregaticio() {
        return tipoVinculoEmpregaticio;
    }

    public void setTipoVinculoEmpregaticio(TipoVinculoEmpregaticio tipoVinculoEmpregaticio) {
        this.tipoVinculoEmpregaticio = tipoVinculoEmpregaticio;
    }

    public DadosBancarios getDadosBancarios() {
        return dadosBancarios;
    }

    public void setDadosBancarios(DadosBancarios dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public MotivoDesligamento getMotivoDesligamento() {
        return motivoDesligamento;
    }

    public void setMotivoDesligamento(MotivoDesligamento motivoDesligamento) {
        this.motivoDesligamento = motivoDesligamento;
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
