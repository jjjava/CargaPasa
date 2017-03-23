package org.pasa.sispasa.cargapasa.model;

import java.util.Date;
import java.util.List;
import org.pasa.sispasa.cargapasa.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class Participante {

    private Long id;
    private Long idUsuario;
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private Date dataFalecimento;
    private Date dataInativacao;
    private String sexo;
    private String nomeMae;
    private String nomePai;
    private String email;
    private String emailComercial;
    private Integer indConclusaoEscolaridade;
    private Integer indAtivo;
    private Date dataUltimaAtualizacao;
    private Long associado;
    private Long endereco;
    private List<Long> partDadosBancarios;
    private Long nacionalidade;
    private Long naturalidade;
    private Long cidadeOrigem;
    private Long nivelEscolaridade;
    private Long estadoCivil;
    private List<Long> telefones;
    private List<Long> documentos;

    public Participante() {
        this.indAtivo = 1;
        this.idUsuario = 1L;
        this.dataUltimaAtualizacao = DateUtil.obterDataAtual();
    }

    public Participante(Long id) {
        this.id = id;
        this.indAtivo = 1;
        this.idUsuario = 1L;
        this.dataUltimaAtualizacao = DateUtil.obterDataAtual();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(Date dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public Date getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailComercial() {
        return emailComercial;
    }

    public void setEmailComercial(String emailComercial) {
        this.emailComercial = emailComercial;
    }

    public Integer getIndConclusaoEscolaridade() {
        return indConclusaoEscolaridade;
    }

    public void setIndConclusaoEscolaridade(Integer indConclusaoEscolaridade) {
        this.indConclusaoEscolaridade = indConclusaoEscolaridade;
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

    public Long getAssociado() {
        return associado;
    }

    public void setAssociado(Long associado) {
        this.associado = associado;
    }

    public Long getEndereco() {
        return endereco;
    }

    public void setEndereco(Long endereco) {
        this.endereco = endereco;
    }

    public List<Long> getPartDadosBancarios() {
        return partDadosBancarios;
    }

    public void setPartDadosBancarios(List<Long> partDadosBancarios) {
        this.partDadosBancarios = partDadosBancarios;
    }

    public Long getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Long nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Long getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Long naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Long getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Long cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Long getNivelEscolaridade() {
        return nivelEscolaridade;
    }

    public void setNivelEscolaridade(Long nivelEscolaridade) {
        this.nivelEscolaridade = nivelEscolaridade;
    }

    public Long getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Long estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<Long> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Long> telefones) {
        this.telefones = telefones;
    }

    public List<Long> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Long> documentos) {
        this.documentos = documentos;
    }
}
