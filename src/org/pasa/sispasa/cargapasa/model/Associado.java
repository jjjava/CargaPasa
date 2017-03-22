
package org.pasa.sispasa.cargapasa.model;

import java.util.Date;
import org.pasa.sispasa.cargapasa.enumeration.EnumTipoAposentadoria;
import org.pasa.sispasa.cargapasa.enumeration.EnumTipoAssociado;
import org.pasa.sispasa.cargapasa.enumeration.EnumTipoRespPagamento;

/**
 *
 * @author Hudson Schumaker
 */
public class Associado {

    private Long id;
    private String matriculaPasa;
    private String matriculaValiaRepresentante;
    private String matriculaValiaParticipante;
    private EnumTipoRespPagamento tipoRespPagamento;
    private EnumTipoAposentadoria tipoAposentadoria;
    private EnumTipoAssociado tipoAssociado;
    private Date dataAssociacao;
    private Date dataAposentadoria;
    private Date dataAdmissaoGrupo;
    private Date dataDesligamentoGrupo;
    private Date dataDesligamentoAssociacao;
    private Date dataReadmissao;
    private Long idUsuario;
    private Date dataUltimaAlteracao;
    private Funcionario funcionario;
    private Participante participante;
    private Associado associadoOrigem;
    private MotivoDesligamento motivoDesligamentoGrupo;
    private MotivoDesligamento motivoDesligamentoAssociado;
    private TaxaAssociado taxaAssociado;
    private SituacaoAssociado situacaoAssociado;
    private ResponsavelLegal responsavelLegal;
    
    public Associado(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriculaPasa() {
        return matriculaPasa;
    }

    public void setMatriculaPasa(String matriculaPasa) {
        this.matriculaPasa = matriculaPasa;
    }

    public String getMatriculaValiaRepresentante() {
        return matriculaValiaRepresentante;
    }

    public void setMatriculaValiaRepresentante(String matriculaValiaRepresentante) {
        this.matriculaValiaRepresentante = matriculaValiaRepresentante;
    }

    public String getMatriculaValiaParticipante() {
        return matriculaValiaParticipante;
    }

    public void setMatriculaValiaParticipante(String matriculaValiaParticipante) {
        this.matriculaValiaParticipante = matriculaValiaParticipante;
    }

    public EnumTipoRespPagamento getTipoRespPagamento() {
        return tipoRespPagamento;
    }

    public void setTipoRespPagamento(EnumTipoRespPagamento tipoRespPagamento) {
        this.tipoRespPagamento = tipoRespPagamento;
    }

    public EnumTipoAposentadoria getTipoAposentadoria() {
        return tipoAposentadoria;
    }

    public void setTipoAposentadoria(EnumTipoAposentadoria tipoAposentadoria) {
        this.tipoAposentadoria = tipoAposentadoria;
    }

    public EnumTipoAssociado getTipoAssociado() {
        return tipoAssociado;
    }

    public void setTipoAssociado(EnumTipoAssociado tipoAssociado) {
        this.tipoAssociado = tipoAssociado;
    }

    public Date getDataAssociacao() {
        return dataAssociacao;
    }

    public void setDataAssociacao(Date dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }

    public Date getDataAposentadoria() {
        return dataAposentadoria;
    }

    public void setDataAposentadoria(Date dataAposentadoria) {
        this.dataAposentadoria = dataAposentadoria;
    }

    public Date getDataAdmissaoGrupo() {
        return dataAdmissaoGrupo;
    }

    public void setDataAdmissaoGrupo(Date dataAdmissaoGrupo) {
        this.dataAdmissaoGrupo = dataAdmissaoGrupo;
    }

    public Date getDataDesligamentoGrupo() {
        return dataDesligamentoGrupo;
    }

    public void setDataDesligamentoGrupo(Date dataDesligamentoGrupo) {
        this.dataDesligamentoGrupo = dataDesligamentoGrupo;
    }

    public Date getDataDesligamentoAssociacao() {
        return dataDesligamentoAssociacao;
    }

    public void setDataDesligamentoAssociacao(Date dataDesligamentoAssociacao) {
        this.dataDesligamentoAssociacao = dataDesligamentoAssociacao;
    }

    public Date getDataReadmissao() {
        return dataReadmissao;
    }

    public void setDataReadmissao(Date dataReadmissao) {
        this.dataReadmissao = dataReadmissao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Associado getAssociadoOrigem() {
        return associadoOrigem;
    }

    public void setAssociadoOrigem(Associado associadoOrigem) {
        this.associadoOrigem = associadoOrigem;
    }

    public MotivoDesligamento getMotivoDesligamentoGrupo() {
        return motivoDesligamentoGrupo;
    }

    public void setMotivoDesligamentoGrupo(MotivoDesligamento motivoDesligamentoGrupo) {
        this.motivoDesligamentoGrupo = motivoDesligamentoGrupo;
    }

    public MotivoDesligamento getMotivoDesligamentoAssociado() {
        return motivoDesligamentoAssociado;
    }

    public void setMotivoDesligamentoAssociado(MotivoDesligamento motivoDesligamentoAssociado) {
        this.motivoDesligamentoAssociado = motivoDesligamentoAssociado;
    }

    public TaxaAssociado getTaxaAssociado() {
        return taxaAssociado;
    }

    public void setTaxaAssociado(TaxaAssociado taxaAssociado) {
        this.taxaAssociado = taxaAssociado;
    }

    public SituacaoAssociado getSituacaoAssociado() {
        return situacaoAssociado;
    }

    public void setSituacaoAssociado(SituacaoAssociado situacaoAssociado) {
        this.situacaoAssociado = situacaoAssociado;
    }

    public ResponsavelLegal getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(ResponsavelLegal responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }
}