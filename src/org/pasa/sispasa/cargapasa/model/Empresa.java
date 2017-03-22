package org.pasa.sispasa.cargapasa.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public class Empresa {

    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private Date dataInicio;
    private Date dataFim;
    private String codCNAE;
    private String email;
    private String site;
    private String codEmpresaVale;
    private Integer indAtivo;
    private Long idUsuario;
    private Date dataUltimaAtualizacao;
    private TipoEmpresa tipoEmpresa;
    private TipoIntegracao tipoIntegracao;
    
    private List<Endereco> enderecos;
    private List<Contato> contatos;
    private List<Contrato> contratos;
    private List<Convenio> convenios;
    
    public Empresa(){
    }
    
    public Empresa(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getCodCNAE() {
        return codCNAE;
    }

    public void setCodCNAE(String codCNAE) {
        this.codCNAE = codCNAE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCodEmpresaVale() {
        return codEmpresaVale;
    }

    public void setCodEmpresaVale(String codEmpresaVale) {
        this.codEmpresaVale = codEmpresaVale;
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

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public TipoIntegracao getTipoIntegracao() {
        return tipoIntegracao;
    }

    public void setTipoIntegracao(TipoIntegracao tipoIntegracao) {
        this.tipoIntegracao = tipoIntegracao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }
}
