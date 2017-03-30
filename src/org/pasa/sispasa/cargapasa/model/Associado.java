package org.pasa.sispasa.cargapasa.model;

import java.util.Date;
import org.pasa.sispasa.cargapasa.enumeration.EnumTipoAposentadoria;
import org.pasa.sispasa.cargapasa.enumeration.EnumTipoRespPagamento;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class Associado {

    private Long id;
    private String matriculaPasa;
    private String matriculaValiaRepresentante;
    private String matriculaValiaParticipante;
    private String tipoRespPagamento;
    private EnumTipoAposentadoria tipoAposentadoria;
    private Date dataAssociacao;
    private Date dataAposentadoria;
    private Date dataAdmissaoGrupo;
    private Date dataDesligamentoGrupo;
    private Date dataDesligamentoAssociacao;
    private Date dataReadmissao;
    private Date dataUltimaAlteracao;
    private Long idUsuario;
    private Long idFuncionario;
    private Long idTaxaAssociado;
    private Long idSituacaoAssociado;
    private Long idParticipante;
    private String tipoAssociado;
    private String categoria;
    private Associado associadoOrigem;
    private MotivoDesligamento motivoDesligamentoGrupo;
    private MotivoDesligamento motivoDesligamentoAssociado;
    private ResponsavelLegal responsavelLegal;

    public Associado() {
        this.idUsuario = CargaPasaCommon.USER_CARGA;
    }

    public Associado(Long id) {
        this.id = id;
        this.idUsuario = CargaPasaCommon.USER_CARGA;
        this.dataUltimaAlteracao = DateUtil.obterDataAtual();
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

    public String getTipoRespPagamento() {
        return tipoRespPagamento;
    }

    public void setTipoRespPagamento(String tipoRespPagamento) {
        this.tipoRespPagamento = tipoRespPagamento;
    }

    public EnumTipoAposentadoria getTipoAposentadoria() {
        return tipoAposentadoria;
    }

    public void setTipoAposentadoria(EnumTipoAposentadoria tipoAposentadoria) {
        this.tipoAposentadoria = tipoAposentadoria;
    }

    public String getTipoAssociado() {
        return tipoAssociado;
    }

    public void setTipoAssociado(String tipoAssociado) {
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

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Long getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Long idParticipante) {
        this.idParticipante = idParticipante;
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

    public Long getIdTaxaAssociado() {
        return idTaxaAssociado;
    }

    public void setIdTaxaAssociado(Long idTaxaAssociado) {
        this.idTaxaAssociado = idTaxaAssociado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getIdSituacaoAssociado() {
        return idSituacaoAssociado;
    }

    public void setIdSituacaoAssociado(Long idSituacaoAssociado) {
        this.idSituacaoAssociado = idSituacaoAssociado;
    }
    
    public ResponsavelLegal getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(ResponsavelLegal responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }
}
