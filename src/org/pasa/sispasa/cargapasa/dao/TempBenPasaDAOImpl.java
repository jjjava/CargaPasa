package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasa.cargapasa.connection.SQLServerConnection;
import org.pasa.sispasa.cargapasa.map.MapaCampos;
import org.pasa.sispasa.cargapasa.load.TempBenPASA;

/**
 *
 * @author Hudson Schumaker
 */
public class TempBenPasaDAOImpl {

    private final Connection conn;

    public TempBenPasaDAOImpl() {
        conn = SQLServerConnection.getConnectionPipe();
    }

    public TempBenPASA get(Long id) {
        TempBenPASA modelo = new TempBenPASA();
        String sql = "select * from TB_TEMP_BEN_PASA where id = " + id;

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setDireitoAMSCredenciamento(rs.getString("direitoAMSCredenciamento"));
                modelo.setDataValidadeCredenciado(rs.getString("dataValidadeCredenciado"));
                modelo.setDireitoAmsReembolso(rs.getString("direitoAmsReembolso"));
                modelo.setDataValidadeReembolso(rs.getString("dataValidadeReembolso"));
                modelo.setDataDeAtualizacao(rs.getString("dataDeAtualizacao"));
                modelo.setNomeBeneficiarioAbreviado(rs.getString("nomeBeneficiarioAbreviado"));
                modelo.setCodigoCR(rs.getString("codigoCR"));
                modelo.setOrgaoPessoal(rs.getString("orgaoPessoal"));
                modelo.setVinculo(rs.getString("vinculo"));
                modelo.setPlano(rs.getString("plano"));
                modelo.setFaixaNivel(rs.getString("faixaNivel"));
                modelo.setDataNascimento(rs.getString("dataNascimento"));
                modelo.setDireitoAbaterIR(rs.getString("direitoAbaterIR"));
                modelo.setNucleoDaAms(rs.getString("nucleoDaAms"));
                modelo.setAgenciaBancaria(rs.getString("agenciaBancaria"));
                modelo.setBanco(rs.getString("banco"));
                modelo.setContaCorrente(rs.getString("contaCorrente"));
                modelo.setDataAdmissao(rs.getString("dataAdmissao"));
                modelo.setGrauParentesco(rs.getString("grauParentesco"));
                modelo.setFinanceira(rs.getString("financeira"));
                modelo.setContratoTrabalho(rs.getString("contratoTrabalho"));
                modelo.setSexo(rs.getString("sexo"));
                modelo.setEmpresaAtualizador(rs.getString("empresaAtualizador"));
                modelo.setMatriculaAtulizador(rs.getString("matriculaAtualizador"));
                modelo.setTipoBeneficiario(rs.getString("tipoBeneficiario"));
                modelo.setCodigoDireitoPasa(rs.getString("codigoDireitoPasa"));
                modelo.setGrauEscolaridade(rs.getString("grauEscolaridade"));
                modelo.setIndicadorConclusao(rs.getString("indicadorConclusao"));
                modelo.setDataFalecimento(rs.getString("dataFalecimento"));
                modelo.setMatriculaPasa(rs.getString("matriculaPasa"));
                modelo.setNomeDaMae(rs.getString("nomeDaMae"));
                modelo.setPis(rs.getString("pis"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setEmpresaOrigem(rs.getString("empresaOrigem"));
                modelo.setMatriculaOrigem(rs.getString("matriculaOrigem"));
                modelo.setEmpresaPeople(rs.getString("empresaPeople"));
                modelo.setMatriculaPeople(rs.getString("matriculaPeople"));
                modelo.setUnidadeDeControle(rs.getString("unidadeDeControle"));
                modelo.setCentroDeCusto(rs.getString("centroDeCusto"));
                modelo.setMatriculaParticipante(rs.getString("matriculaParticipante"));
                modelo.setMatriculaRepresentanteLegal(rs.getString("matriculaRepresentanteLegal"));
                modelo.setCategoriaPASA(rs.getString("categoriaPASA"));
                modelo.setDataAdesao(rs.getString("dataAdesao"));
                modelo.setDataInicioCarencia(rs.getString("dataInicioCarencia"));
                modelo.setDataFimCarencia(rs.getString("dataFimCarencia"));
                modelo.setNomeCompleto(rs.getString("nomeCompleto"));
                modelo.setDiasDeCarencia(rs.getString("diasDeCarencia"));
                modelo.setCodigoNacionalDeSaude(rs.getString("codigoNacionalDeSaude"));
                modelo.setDeclaracaoNascidoVivo(rs.getString("declaracaoNascidoVivo"));
                modelo.setOk(rs.getInt("ok"));
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelo;
    }

    public TempBenPASA get(String matricula) {
        TempBenPASA modelo = new TempBenPASA();
        String sql = "select * from TB_TEMP_BEN_PASA where matricula = '" + matricula + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setDireitoAMSCredenciamento(rs.getString("direitoAMSCredenciamento"));
                modelo.setDataValidadeCredenciado(rs.getString("dataValidadeCredenciado"));
                modelo.setDireitoAmsReembolso(rs.getString("direitoAmsReembolso"));
                modelo.setDataValidadeReembolso(rs.getString("dataValidadeReembolso"));
                modelo.setDataDeAtualizacao(rs.getString("dataDeAtualizacao"));
                modelo.setNomeBeneficiarioAbreviado(rs.getString("nomeBeneficiarioAbreviado"));
                modelo.setCodigoCR(rs.getString("codigoCR"));
                modelo.setOrgaoPessoal(rs.getString("orgaoPessoal"));
                modelo.setVinculo(rs.getString("vinculo"));
                modelo.setPlano(rs.getString("plano"));
                modelo.setFaixaNivel(rs.getString("faixaNivel"));
                modelo.setDataNascimento(rs.getString("dataNascimento"));
                modelo.setDireitoAbaterIR(rs.getString("direitoAbaterIR"));
                modelo.setNucleoDaAms(rs.getString("nucleoDaAms"));
                modelo.setAgenciaBancaria(rs.getString("agenciaBancaria"));
                modelo.setBanco(rs.getString("banco"));
                modelo.setContaCorrente(rs.getString("contaCorrente"));
                modelo.setDataAdmissao(rs.getString("dataAdmissao"));
                modelo.setGrauParentesco(rs.getString("grauParentesco"));
                modelo.setFinanceira(rs.getString("financeira"));
                modelo.setContratoTrabalho(rs.getString("contratoTrabalho"));
                modelo.setSexo(rs.getString("sexo"));
                modelo.setEmpresaAtualizador(rs.getString("empresaAtualizador"));
                modelo.setMatriculaAtulizador(rs.getString("matriculaAtualizador"));
                modelo.setTipoBeneficiario(rs.getString("tipoBeneficiario"));
                modelo.setCodigoDireitoPasa(rs.getString("codigoDireitoPasa"));
                modelo.setGrauEscolaridade(rs.getString("grauEscolaridade"));
                modelo.setIndicadorConclusao(rs.getString("indicadorConclusao"));
                modelo.setDataFalecimento(rs.getString("dataFalecimento"));
                modelo.setMatriculaPasa(rs.getString("matriculaPasa"));
                modelo.setNomeDaMae(rs.getString("nomeDaMae"));
                modelo.setPis(rs.getString("pis"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setEmpresaOrigem(rs.getString("empresaOrigem"));
                modelo.setMatriculaOrigem(rs.getString("matriculaOrigem"));
                modelo.setEmpresaPeople(rs.getString("empresaPeople"));
                modelo.setMatriculaPeople(rs.getString("matriculaPeople"));
                modelo.setUnidadeDeControle(rs.getString("unidadeDeControle"));
                modelo.setCentroDeCusto(rs.getString("centroDeCusto"));
                modelo.setMatriculaParticipante(rs.getString("matriculaParticipante"));
                modelo.setMatriculaRepresentanteLegal(rs.getString("matriculaRepresentanteLegal"));
                modelo.setCategoriaPASA(rs.getString("categoriaPASA"));
                modelo.setDataAdesao(rs.getString("dataAdesao"));
                modelo.setDataInicioCarencia(rs.getString("dataInicioCarencia"));
                modelo.setDataFimCarencia(rs.getString("dataFimCarencia"));
                modelo.setNomeCompleto(rs.getString("nomeCompleto"));
                modelo.setDiasDeCarencia(rs.getString("diasDeCarencia"));
                modelo.setCodigoNacionalDeSaude(rs.getString("codigoNacionalDeSaude"));
                modelo.setDeclaracaoNascidoVivo(rs.getString("declaracaoNascidoVivo"));
                modelo.setOk(rs.getInt("ok"));
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelo;
    }

    public TempBenPASA get(String empresa, String matricula) {
        TempBenPASA modelo = new TempBenPASA();
        String sql = "select * from TB_TEMP_BEN_PASA where empresa = '" + empresa
                + "' and matricula = '" + matricula + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setDireitoAMSCredenciamento(rs.getString("direitoAMSCredenciamento"));
                modelo.setDataValidadeCredenciado(rs.getString("dataValidadeCredenciado"));
                modelo.setDireitoAmsReembolso(rs.getString("direitoAmsReembolso"));
                modelo.setDataValidadeReembolso(rs.getString("dataValidadeReembolso"));
                modelo.setDataDeAtualizacao(rs.getString("dataDeAtualizacao"));
                modelo.setNomeBeneficiarioAbreviado(rs.getString("nomeBeneficiarioAbreviado"));
                modelo.setCodigoCR(rs.getString("codigoCR"));
                modelo.setOrgaoPessoal(rs.getString("orgaoPessoal"));
                modelo.setVinculo(rs.getString("vinculo"));
                modelo.setPlano(rs.getString("plano"));
                modelo.setFaixaNivel(rs.getString("faixaNivel"));
                modelo.setDataNascimento(rs.getString("dataNascimento"));
                modelo.setDireitoAbaterIR(rs.getString("direitoAbaterIR"));
                modelo.setNucleoDaAms(rs.getString("nucleoDaAms"));
                modelo.setAgenciaBancaria(rs.getString("agenciaBancaria"));
                modelo.setBanco(rs.getString("banco"));
                modelo.setContaCorrente(rs.getString("contaCorrente"));
                modelo.setDataAdmissao(rs.getString("dataAdmissao"));
                modelo.setGrauParentesco(rs.getString("grauParentesco"));
                modelo.setFinanceira(rs.getString("financeira"));
                modelo.setContratoTrabalho(rs.getString("contratoTrabalho"));
                modelo.setSexo(rs.getString("sexo"));
                modelo.setEmpresaAtualizador(rs.getString("empresaAtualizador"));
                modelo.setMatriculaAtulizador(rs.getString("matriculaAtualizador"));
                modelo.setTipoBeneficiario(rs.getString("tipoBeneficiario"));
                modelo.setCodigoDireitoPasa(rs.getString("codigoDireitoPasa"));
                modelo.setGrauEscolaridade(rs.getString("grauEscolaridade"));
                modelo.setIndicadorConclusao(rs.getString("indicadorConclusao"));
                modelo.setDataFalecimento(rs.getString("dataFalecimento"));
                modelo.setMatriculaPasa(rs.getString("matriculaPasa"));
                modelo.setNomeDaMae(rs.getString("nomeDaMae"));
                modelo.setPis(rs.getString("pis"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setEmpresaOrigem(rs.getString("empresaOrigem"));
                modelo.setMatriculaOrigem(rs.getString("matriculaOrigem"));
                modelo.setEmpresaPeople(rs.getString("empresaPeople"));
                modelo.setMatriculaPeople(rs.getString("matriculaPeople"));
                modelo.setUnidadeDeControle(rs.getString("unidadeDeControle"));
                modelo.setCentroDeCusto(rs.getString("centroDeCusto"));
                modelo.setMatriculaParticipante(rs.getString("matriculaParticipante"));
                modelo.setMatriculaRepresentanteLegal(rs.getString("matriculaRepresentanteLegal"));
                modelo.setCategoriaPASA(rs.getString("categoriaPASA"));
                modelo.setDataAdesao(rs.getString("dataAdesao"));
                modelo.setDataInicioCarencia(rs.getString("dataInicioCarencia"));
                modelo.setDataFimCarencia(rs.getString("dataFimCarencia"));
                modelo.setNomeCompleto(rs.getString("nomeCompleto"));
                modelo.setDiasDeCarencia(rs.getString("diasDeCarencia"));
                modelo.setCodigoNacionalDeSaude(rs.getString("codigoNacionalDeSaude"));
                modelo.setDeclaracaoNascidoVivo(rs.getString("declaracaoNascidoVivo"));
                modelo.setOk(rs.getInt("ok"));
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelo;
    }

    public TempBenPASA get(String empresa, String matricula, String codBenef) {
        TempBenPASA modelo = new TempBenPASA();
        String sql = "select * from TB_TEMP_BEN_PASA where empresa = '" + empresa
                + "' and matricula = '" + matricula + "' and codBeneficiario = '" + codBenef + "'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setDireitoAMSCredenciamento(rs.getString("direitoAMSCredenciamento"));
                modelo.setDataValidadeCredenciado(rs.getString("dataValidadeCredenciado"));
                modelo.setDireitoAmsReembolso(rs.getString("direitoAmsReembolso"));
                modelo.setDataValidadeReembolso(rs.getString("dataValidadeReembolso"));
                modelo.setDataDeAtualizacao(rs.getString("dataDeAtualizacao"));
                modelo.setNomeBeneficiarioAbreviado(rs.getString("nomeBeneficiarioAbreviado"));
                modelo.setCodigoCR(rs.getString("codigoCR"));
                modelo.setOrgaoPessoal(rs.getString("orgaoPessoal"));
                modelo.setVinculo(rs.getString("vinculo"));
                modelo.setPlano(rs.getString("plano"));
                modelo.setFaixaNivel(rs.getString("faixaNivel"));
                modelo.setDataNascimento(rs.getString("dataNascimento"));
                modelo.setDireitoAbaterIR(rs.getString("direitoAbaterIR"));
                modelo.setNucleoDaAms(rs.getString("nucleoDaAms"));
                modelo.setAgenciaBancaria(rs.getString("agenciaBancaria"));
                modelo.setBanco(rs.getString("banco"));
                modelo.setContaCorrente(rs.getString("contaCorrente"));
                modelo.setDataAdmissao(rs.getString("dataAdmissao"));
                modelo.setGrauParentesco(rs.getString("grauParentesco"));
                modelo.setFinanceira(rs.getString("financeira"));
                modelo.setContratoTrabalho(rs.getString("contratoTrabalho"));
                modelo.setSexo(rs.getString("sexo"));
                modelo.setEmpresaAtualizador(rs.getString("empresaAtualizador"));
                modelo.setMatriculaAtulizador(rs.getString("matriculaAtualizador"));
                modelo.setTipoBeneficiario(rs.getString("tipoBeneficiario"));
                modelo.setCodigoDireitoPasa(rs.getString("codigoDireitoPasa"));
                modelo.setGrauEscolaridade(rs.getString("grauEscolaridade"));
                modelo.setIndicadorConclusao(rs.getString("indicadorConclusao"));
                modelo.setDataFalecimento(rs.getString("dataFalecimento"));
                modelo.setMatriculaPasa(rs.getString("matriculaPasa"));
                modelo.setNomeDaMae(rs.getString("nomeDaMae"));
                modelo.setPis(rs.getString("pis"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setEmpresaOrigem(rs.getString("empresaOrigem"));
                modelo.setMatriculaOrigem(rs.getString("matriculaOrigem"));
                modelo.setEmpresaPeople(rs.getString("empresaPeople"));
                modelo.setMatriculaPeople(rs.getString("matriculaPeople"));
                modelo.setUnidadeDeControle(rs.getString("unidadeDeControle"));
                modelo.setCentroDeCusto(rs.getString("centroDeCusto"));
                modelo.setMatriculaParticipante(rs.getString("matriculaParticipante"));
                modelo.setMatriculaRepresentanteLegal(rs.getString("matriculaRepresentanteLegal"));
                modelo.setCategoriaPASA(rs.getString("categoriaPASA"));
                modelo.setDataAdesao(rs.getString("dataAdesao"));
                modelo.setDataInicioCarencia(rs.getString("dataInicioCarencia"));
                modelo.setDataFimCarencia(rs.getString("dataFimCarencia"));
                modelo.setNomeCompleto(rs.getString("nomeCompleto"));
                modelo.setDiasDeCarencia(rs.getString("diasDeCarencia"));
                modelo.setCodigoNacionalDeSaude(rs.getString("codigoNacionalDeSaude"));
                modelo.setDeclaracaoNascidoVivo(rs.getString("declaracaoNascidoVivo"));
                modelo.setOk(rs.getInt("ok"));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelo;
    }

    public List<TempBenPASA> getTitular(String empresa, String matriculaOrigem, String tipo) {
        List<TempBenPASA> modelos = new ArrayList<>();
        String sql = "select * from TB_TEMP_BEN_PASA where empresaOrigem = '" + empresa
                + "' and matriculaOrigem = '" + matriculaOrigem + "' and tipoBeneficiario ='" + tipo + "'";
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TempBenPASA modelo = new TempBenPASA();
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setDireitoAMSCredenciamento(rs.getString("direitoAMSCredenciamento"));
                modelo.setDataValidadeCredenciado(rs.getString("dataValidadeCredenciado"));
                modelo.setDireitoAmsReembolso(rs.getString("direitoAmsReembolso"));
                modelo.setDataValidadeReembolso(rs.getString("dataValidadeReembolso"));
                modelo.setDataDeAtualizacao(rs.getString("dataDeAtualizacao"));
                modelo.setNomeBeneficiarioAbreviado(rs.getString("nomeBeneficiarioAbreviado"));
                modelo.setCodigoCR(rs.getString("codigoCR"));
                modelo.setOrgaoPessoal(rs.getString("orgaoPessoal"));
                modelo.setVinculo(rs.getString("vinculo"));
                modelo.setPlano(rs.getString("plano"));
                modelo.setFaixaNivel(rs.getString("faixaNivel"));
                modelo.setDataNascimento(rs.getString("dataNascimento"));
                modelo.setDireitoAbaterIR(rs.getString("direitoAbaterIR"));
                modelo.setNucleoDaAms(rs.getString("nucleoDaAms"));
                modelo.setAgenciaBancaria(rs.getString("agenciaBancaria"));
                modelo.setBanco(rs.getString("banco"));
                modelo.setContaCorrente(rs.getString("contaCorrente"));
                modelo.setDataAdmissao(rs.getString("dataAdmissao"));
                modelo.setGrauParentesco(rs.getString("grauParentesco"));
                modelo.setFinanceira(rs.getString("financeira"));
                modelo.setContratoTrabalho(rs.getString("contratoTrabalho"));
                modelo.setSexo(rs.getString("sexo"));
                modelo.setEmpresaAtualizador(rs.getString("empresaAtualizador"));
                modelo.setMatriculaAtulizador(rs.getString("matriculaAtualizador"));
                modelo.setTipoBeneficiario(rs.getString("tipoBeneficiario"));
                modelo.setCodigoDireitoPasa(rs.getString("codigoDireitoPasa"));
                modelo.setGrauEscolaridade(rs.getString("grauEscolaridade"));
                modelo.setIndicadorConclusao(rs.getString("indicadorConclusao"));
                modelo.setDataFalecimento(rs.getString("dataFalecimento"));
                modelo.setMatriculaPasa(rs.getString("matriculaPasa"));
                modelo.setNomeDaMae(rs.getString("nomeDaMae"));
                modelo.setPis(rs.getString("pis"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setEmpresaOrigem(rs.getString("empresaOrigem"));
                modelo.setMatriculaOrigem(rs.getString("matriculaOrigem"));
                modelo.setEmpresaPeople(rs.getString("empresaPeople"));
                modelo.setMatriculaPeople(rs.getString("matriculaPeople"));
                modelo.setUnidadeDeControle(rs.getString("unidadeDeControle"));
                modelo.setCentroDeCusto(rs.getString("centroDeCusto"));
                modelo.setMatriculaParticipante(rs.getString("matriculaParticipante"));
                modelo.setMatriculaRepresentanteLegal(rs.getString("matriculaRepresentanteLegal"));
                modelo.setCategoriaPASA(rs.getString("categoriaPASA"));
                modelo.setDataAdesao(rs.getString("dataAdesao"));
                modelo.setDataInicioCarencia(rs.getString("dataInicioCarencia"));
                modelo.setDataFimCarencia(rs.getString("dataFimCarencia"));
                modelo.setNomeCompleto(rs.getString("nomeCompleto"));
                modelo.setDiasDeCarencia(rs.getString("diasDeCarencia"));
                modelo.setCodigoNacionalDeSaude(rs.getString("codigoNacionalDeSaude"));
                modelo.setDeclaracaoNascidoVivo(rs.getString("declaracaoNascidoVivo"));

                modelos.add(modelo);//ADD NA LISTA
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelos;
    }

    public List<TempBenPASA> getUsuarios(String empresa, String matricula) {
        List<TempBenPASA> modelos = new ArrayList<>();
        String sql = "select * from TB_TEMP_BEN_PASA where empresaOrigem = '" + empresa
                + "' and matriculaOrigem = '" + matricula + "' and tipoBeneficiario not in('A','B')";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TempBenPASA modelo = new TempBenPASA();
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setDireitoAMSCredenciamento(rs.getString("direitoAMSCredenciamento"));
                modelo.setDataValidadeCredenciado(rs.getString("dataValidadeCredenciado"));
                modelo.setDireitoAmsReembolso(rs.getString("direitoAmsReembolso"));
                modelo.setDataValidadeReembolso(rs.getString("dataValidadeReembolso"));
                modelo.setDataDeAtualizacao(rs.getString("dataDeAtualizacao"));
                modelo.setNomeBeneficiarioAbreviado(rs.getString("nomeBeneficiarioAbreviado"));
                modelo.setCodigoCR(rs.getString("codigoCR"));
                modelo.setOrgaoPessoal(rs.getString("orgaoPessoal"));
                modelo.setVinculo(rs.getString("vinculo"));
                modelo.setPlano(rs.getString("plano"));
                modelo.setFaixaNivel(rs.getString("faixaNivel"));
                modelo.setDataNascimento(rs.getString("dataNascimento"));
                modelo.setDireitoAbaterIR(rs.getString("direitoAbaterIR"));
                modelo.setNucleoDaAms(rs.getString("nucleoDaAms"));
                modelo.setAgenciaBancaria(rs.getString("agenciaBancaria"));
                modelo.setBanco(rs.getString("banco"));
                modelo.setContaCorrente(rs.getString("contaCorrente"));
                modelo.setDataAdmissao(rs.getString("dataAdmissao"));
                modelo.setGrauParentesco(rs.getString("grauParentesco"));
                modelo.setFinanceira(rs.getString("financeira"));
                modelo.setContratoTrabalho(rs.getString("contratoTrabalho"));
                modelo.setSexo(rs.getString("sexo"));
                modelo.setEmpresaAtualizador(rs.getString("empresaAtualizador"));
                modelo.setMatriculaAtulizador(rs.getString("matriculaAtualizador"));
                modelo.setTipoBeneficiario(rs.getString("tipoBeneficiario"));
                modelo.setCodigoDireitoPasa(rs.getString("codigoDireitoPasa"));
                modelo.setGrauEscolaridade(rs.getString("grauEscolaridade"));
                modelo.setIndicadorConclusao(rs.getString("indicadorConclusao"));
                modelo.setDataFalecimento(rs.getString("dataFalecimento"));
                modelo.setMatriculaPasa(rs.getString("matriculaPasa"));
                modelo.setNomeDaMae(rs.getString("nomeDaMae"));
                modelo.setPis(rs.getString("pis"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setEmpresaOrigem(rs.getString("empresaOrigem"));
                modelo.setMatriculaOrigem(rs.getString("matriculaOrigem"));
                modelo.setEmpresaPeople(rs.getString("empresaPeople"));
                modelo.setMatriculaPeople(rs.getString("matriculaPeople"));
                modelo.setUnidadeDeControle(rs.getString("unidadeDeControle"));
                modelo.setCentroDeCusto(rs.getString("centroDeCusto"));
                modelo.setMatriculaParticipante(rs.getString("matriculaParticipante"));
                modelo.setMatriculaRepresentanteLegal(rs.getString("matriculaRepresentanteLegal"));
                modelo.setCategoriaPASA(rs.getString("categoriaPASA"));
                modelo.setDataAdesao(rs.getString("dataAdesao"));
                modelo.setDataInicioCarencia(rs.getString("dataInicioCarencia"));
                modelo.setDataFimCarencia(rs.getString("dataFimCarencia"));
                modelo.setNomeCompleto(rs.getString("nomeCompleto"));
                modelo.setDiasDeCarencia(rs.getString("diasDeCarencia"));
                modelo.setCodigoNacionalDeSaude(rs.getString("codigoNacionalDeSaude"));
                modelo.setDeclaracaoNascidoVivo(rs.getString("declaracaoNascidoVivo"));

                modelos.add(modelo);//ADD NA LISTA
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelos;
    }

    public List<TempBenPASA> getUsuariosTitulares(String empresaOrigem, String matriculaOrigem, String tipo) {
        List<TempBenPASA> modelos = new ArrayList<>();
        String sql = "select * from TB_TEMP_BEN_PASA where empresaOrigem = '" + empresaOrigem
                + "' and matriculaOrigem = '" + matriculaOrigem + "' and tipoBeneficiario ='" + tipo + "'";
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TempBenPASA modelo = new TempBenPASA();
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setDireitoAMSCredenciamento(rs.getString("direitoAMSCredenciamento"));
                modelo.setDataValidadeCredenciado(rs.getString("dataValidadeCredenciado"));
                modelo.setDireitoAmsReembolso(rs.getString("direitoAmsReembolso"));
                modelo.setDataValidadeReembolso(rs.getString("dataValidadeReembolso"));
                modelo.setDataDeAtualizacao(rs.getString("dataDeAtualizacao"));
                modelo.setNomeBeneficiarioAbreviado(rs.getString("nomeBeneficiarioAbreviado"));
                modelo.setCodigoCR(rs.getString("codigoCR"));
                modelo.setOrgaoPessoal(rs.getString("orgaoPessoal"));
                modelo.setVinculo(rs.getString("vinculo"));
                modelo.setPlano(rs.getString("plano"));
                modelo.setFaixaNivel(rs.getString("faixaNivel"));
                modelo.setDataNascimento(rs.getString("dataNascimento"));
                modelo.setDireitoAbaterIR(rs.getString("direitoAbaterIR"));
                modelo.setNucleoDaAms(rs.getString("nucleoDaAms"));
                modelo.setAgenciaBancaria(rs.getString("agenciaBancaria"));
                modelo.setBanco(rs.getString("banco"));
                modelo.setContaCorrente(rs.getString("contaCorrente"));
                modelo.setDataAdmissao(rs.getString("dataAdmissao"));
                modelo.setGrauParentesco(rs.getString("grauParentesco"));
                modelo.setFinanceira(rs.getString("financeira"));
                modelo.setContratoTrabalho(rs.getString("contratoTrabalho"));
                modelo.setSexo(rs.getString("sexo"));
                modelo.setEmpresaAtualizador(rs.getString("empresaAtualizador"));
                modelo.setMatriculaAtulizador(rs.getString("matriculaAtualizador"));
                modelo.setTipoBeneficiario(rs.getString("tipoBeneficiario"));
                modelo.setCodigoDireitoPasa(rs.getString("codigoDireitoPasa"));
                modelo.setGrauEscolaridade(rs.getString("grauEscolaridade"));
                modelo.setIndicadorConclusao(rs.getString("indicadorConclusao"));
                modelo.setDataFalecimento(rs.getString("dataFalecimento"));
                modelo.setMatriculaPasa(rs.getString("matriculaPasa"));
                modelo.setNomeDaMae(rs.getString("nomeDaMae"));
                modelo.setPis(rs.getString("pis"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setEmpresaOrigem(rs.getString("empresaOrigem"));
                modelo.setMatriculaOrigem(rs.getString("matriculaOrigem"));
                modelo.setEmpresaPeople(rs.getString("empresaPeople"));
                modelo.setMatriculaPeople(rs.getString("matriculaPeople"));
                modelo.setUnidadeDeControle(rs.getString("unidadeDeControle"));
                modelo.setCentroDeCusto(rs.getString("centroDeCusto"));
                modelo.setMatriculaParticipante(rs.getString("matriculaParticipante"));
                modelo.setMatriculaRepresentanteLegal(rs.getString("matriculaRepresentanteLegal"));
                modelo.setCategoriaPASA(rs.getString("categoriaPASA"));
                modelo.setDataAdesao(rs.getString("dataAdesao"));
                modelo.setDataInicioCarencia(rs.getString("dataInicioCarencia"));
                modelo.setDataFimCarencia(rs.getString("dataFimCarencia"));
                modelo.setNomeCompleto(rs.getString("nomeCompleto"));
                modelo.setDiasDeCarencia(rs.getString("diasDeCarencia"));
                modelo.setCodigoNacionalDeSaude(rs.getString("codigoNacionalDeSaude"));
                modelo.setDeclaracaoNascidoVivo(rs.getString("declaracaoNascidoVivo"));

                modelos.add(modelo);//ADD NA LISTA
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelos;
    }

    public List<TempBenPASA> getUsuariosByMatriculaOrigem(String empresa, String matricula) {
        List<TempBenPASA> modelos = new ArrayList<>();
        String sql = "select * from TB_TEMP_BEN_PASA where empresaOrigem = '" + empresa
                + "' and matriculaOrigem = '" + matricula + "' and codBeneficiario <> '00'";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TempBenPASA modelo = new TempBenPASA();
                modelo.setId(rs.getLong("id"));
                modelo.setEmpresa(rs.getString("empresa"));
                modelo.setMatricula(rs.getString("matricula"));
                modelo.setCodBeneficiario(rs.getString("codBeneficiario"));
                modelo.setDireitoAMSCredenciamento(rs.getString("direitoAMSCredenciamento"));
                modelo.setDataValidadeCredenciado(rs.getString("dataValidadeCredenciado"));
                modelo.setDireitoAmsReembolso(rs.getString("direitoAmsReembolso"));
                modelo.setDataValidadeReembolso(rs.getString("dataValidadeReembolso"));
                modelo.setDataDeAtualizacao(rs.getString("dataDeAtualizacao"));
                modelo.setNomeBeneficiarioAbreviado(rs.getString("nomeBeneficiarioAbreviado"));
                modelo.setCodigoCR(rs.getString("codigoCR"));
                modelo.setOrgaoPessoal(rs.getString("orgaoPessoal"));
                modelo.setVinculo(rs.getString("vinculo"));
                modelo.setPlano(rs.getString("plano"));
                modelo.setFaixaNivel(rs.getString("faixaNivel"));
                modelo.setDataNascimento(rs.getString("dataNascimento"));
                modelo.setDireitoAbaterIR(rs.getString("direitoAbaterIR"));
                modelo.setNucleoDaAms(rs.getString("nucleoDaAms"));
                modelo.setAgenciaBancaria(rs.getString("agenciaBancaria"));
                modelo.setBanco(rs.getString("banco"));
                modelo.setContaCorrente(rs.getString("contaCorrente"));
                modelo.setDataAdmissao(rs.getString("dataAdmissao"));
                modelo.setGrauParentesco(rs.getString("grauParentesco"));
                modelo.setFinanceira(rs.getString("financeira"));
                modelo.setContratoTrabalho(rs.getString("contratoTrabalho"));
                modelo.setSexo(rs.getString("sexo"));
                modelo.setEmpresaAtualizador(rs.getString("empresaAtualizador"));
                modelo.setMatriculaAtulizador(rs.getString("matriculaAtualizador"));
                modelo.setTipoBeneficiario(rs.getString("tipoBeneficiario"));
                modelo.setCodigoDireitoPasa(rs.getString("codigoDireitoPasa"));
                modelo.setGrauEscolaridade(rs.getString("grauEscolaridade"));
                modelo.setIndicadorConclusao(rs.getString("indicadorConclusao"));
                modelo.setDataFalecimento(rs.getString("dataFalecimento"));
                modelo.setMatriculaPasa(rs.getString("matriculaPasa"));
                modelo.setNomeDaMae(rs.getString("nomeDaMae"));
                modelo.setPis(rs.getString("pis"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setEmpresaOrigem(rs.getString("empresaOrigem"));
                modelo.setMatriculaOrigem(rs.getString("matriculaOrigem"));
                modelo.setEmpresaPeople(rs.getString("empresaPeople"));
                modelo.setMatriculaPeople(rs.getString("matriculaPeople"));
                modelo.setUnidadeDeControle(rs.getString("unidadeDeControle"));
                modelo.setCentroDeCusto(rs.getString("centroDeCusto"));
                modelo.setMatriculaParticipante(rs.getString("matriculaParticipante"));
                modelo.setMatriculaRepresentanteLegal(rs.getString("matriculaRepresentanteLegal"));
                modelo.setCategoriaPASA(rs.getString("categoriaPASA"));
                modelo.setDataAdesao(rs.getString("dataAdesao"));
                modelo.setDataInicioCarencia(rs.getString("dataInicioCarencia"));
                modelo.setDataFimCarencia(rs.getString("dataFimCarencia"));
                modelo.setNomeCompleto(rs.getString("nomeCompleto"));
                modelo.setDiasDeCarencia(rs.getString("diasDeCarencia"));
                modelo.setCodigoNacionalDeSaude(rs.getString("codigoNacionalDeSaude"));
                modelo.setDeclaracaoNascidoVivo(rs.getString("declaracaoNascidoVivo"));

                modelos.add(modelo);//ADD NA LISTA
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return modelos;
    }

    public Integer countUsuarios(String empresa, String matricula) {
        return getUsuarios(empresa, matricula).size();
    }

    public Long countTitular(String empresaOrigem, String matriculaOrigem, String tipoBenef) {
        Long count = null;

        String sql = "select count(id) from TB_TEMP_BEN_PASA where empresa = '" + empresaOrigem
                + "' and matriculaOrigem = '" + matriculaOrigem + "' and tipoBeneficiario ='" + tipoBenef + "'";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getLong(1);//nao sei o label q SqlServer gera.
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return count;
    }

    public void save(TempBenPASA modelo) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO TB_TEMP_BEN_PASA ("
                    + MapaCampos.EMPRESA
                    + "," + MapaCampos.MATRICULA
                    + "," + MapaCampos.COD_BENEFICIARIO
                    + "," + MapaCampos.DIREITO_AMS_CREDENCIAMENTO
                    + "," + MapaCampos.DATA_VALIDADE_CREDENCIADO
                    + "," + MapaCampos.DIREITO_AMS_REEMBOLSO
                    + "," + MapaCampos.DATA_VALIDADE_REEMBOLSO
                    + "," + MapaCampos.DATA_DE_ATUALIZACAO
                    + "," + MapaCampos.NOME_BENEFICIARIO_ABREVIADO
                    + "," + MapaCampos.CODIGO_CR
                    + "," + MapaCampos.ORGAO_PESSOAL
                    + "," + MapaCampos.VINCULO
                    + "," + MapaCampos.PLANO
                    + "," + MapaCampos.FAIXA_NIVEL
                    + "," + MapaCampos.DATA_NASCIMENTO
                    + "," + MapaCampos.DIREITO_ABATER_IR
                    + "," + MapaCampos.NUCLEO_DA_AMS
                    + "," + MapaCampos.AGENCIA_BANCARIA
                    + "," + MapaCampos.BANCO
                    + "," + MapaCampos.CONTA_CORRENTE
                    + "," + MapaCampos.DATA_ADMISSAO
                    + "," + MapaCampos.GRAU_PARENTESCO
                    + "," + MapaCampos.FINACEIRA
                    + "," + MapaCampos.CONTRATO_TRABALHO
                    + "," + MapaCampos.SEXO
                    + "," + MapaCampos.EMPRESA_ATUALIZADOR
                    + "," + MapaCampos.MATRICULA_ATUALIZADOR
                    + "," + MapaCampos.TIPO_BENEFICIARIO
                    + "," + MapaCampos.CODIGO_DIREITO_PASA
                    + "," + MapaCampos.GRAU_ESCOLARIDADE
                    + "," + MapaCampos.INDICAR_CONCLUSAO
                    + "," + MapaCampos.DATA_FALECIMENTO
                    + "," + MapaCampos.MATRICULA_PASA
                    + "," + MapaCampos.NOME_DA_MAE
                    + "," + MapaCampos.PIS
                    + "," + MapaCampos.CPF
                    + "," + MapaCampos.EMPRESA_ORIGEM
                    + "," + MapaCampos.MATRICULA_ORIGEM
                    + "," + MapaCampos.EMPRESA_PEOPLE
                    + "," + MapaCampos.MATRICULA_PEOPLE
                    + "," + MapaCampos.UNIDADE_DE_CONTROLE
                    + "," + MapaCampos.CENTRO_DE_CUSTO
                    + "," + MapaCampos.MATRICULA_PARTICIPANTE
                    + "," + MapaCampos.MATRICULA_REPRESENTANTE_LEGAL
                    + "," + MapaCampos.CATEGORIA_PASA
                    + "," + MapaCampos.DATA_ADESAO
                    + "," + MapaCampos.DATA_INICIO_CARENCIA
                    + "," + MapaCampos.DATA_FIM_CARENCIA
                    + "," + MapaCampos.NOME_BENEFICIARIO
                    + "," + MapaCampos.DIAS_DE_CARENCIA
                    + "," + MapaCampos.CODIGO_NACIONAL_SAUDE
                    + "," + MapaCampos.DECLARACAO_NASCIDO_VIVO
                    + ", OK"
                    + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, modelo.getEmpresa());
            ps.setString(2, modelo.getMatricula());
            ps.setString(3, modelo.getCodBeneficiario());
            ps.setString(4, modelo.getDireitoAMSCredenciamento());
            ps.setString(5, modelo.getDataValidadeCredenciado());
            ps.setString(6, modelo.getDireitoAmsReembolso());
            ps.setString(7, modelo.getDataValidadeReembolso());
            ps.setString(8, modelo.getDataDeAtualizacao());
            ps.setString(9, modelo.getNomeBeneficiarioAbreviado());
            ps.setString(10, modelo.getCodigoCR());
            ps.setString(11, modelo.getOrgaoPessoal());
            ps.setString(12, modelo.getVinculo());
            ps.setString(13, modelo.getPlano());
            ps.setString(14, modelo.getFaixaNivel());
            ps.setString(15, modelo.getDataNascimento());
            ps.setString(16, modelo.getDireitoAbaterIR());
            ps.setString(17, modelo.getNucleoDaAms());
            ps.setString(18, modelo.getAgenciaBancaria());
            ps.setString(19, modelo.getBanco());
            ps.setString(20, modelo.getContaCorrente());
            ps.setString(21, modelo.getDataAdmissao());
            ps.setString(22, modelo.getGrauParentesco());
            ps.setString(23, modelo.getFinanceira());
            ps.setString(24, modelo.getContratoTrabalho());
            ps.setString(25, modelo.getSexo());
            ps.setString(26, modelo.getEmpresaAtualizador());
            ps.setString(27, modelo.getMatriculaAtulizador());
            ps.setString(28, modelo.getTipoBeneficiario());
            ps.setString(29, modelo.getCodigoDireitoPasa());
            ps.setString(30, modelo.getGrauEscolaridade());
            ps.setString(31, modelo.getIndicadorConclusao());
            ps.setString(32, modelo.getDataFalecimento());
            ps.setString(33, modelo.getMatriculaPasa());
            ps.setString(34, modelo.getNomeDaMae());
            ps.setString(35, modelo.getPis());
            ps.setString(36, modelo.getCpf());
            ps.setString(37, modelo.getEmpresaOrigem());
            ps.setString(38, modelo.getMatriculaOrigem());
            ps.setString(39, modelo.getEmpresaPeople());
            ps.setString(40, modelo.getMatriculaPeople());
            ps.setString(41, modelo.getUnidadeDeControle());
            ps.setString(42, modelo.getCentroDeCusto());
            ps.setString(43, modelo.getMatriculaParticipante());
            ps.setString(44, modelo.getMatriculaRepresentanteLegal());
            ps.setString(45, modelo.getCategoriaPASA()); // IMPORTANTE 
            ps.setString(46, modelo.getDataAdesao());
            ps.setString(47, modelo.getDataInicioCarencia());
            ps.setString(48, modelo.getDataFimCarencia());
            ps.setString(49, modelo.getNomeCompleto());
            ps.setString(50, modelo.getDiasDeCarencia());
            ps.setString(51, modelo.getCodigoNacionalDeSaude());
            ps.setString(52, modelo.getDeclaracaoNascidoVivo());
            ps.setInt(53, 0);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.err.println(this.getClass().getName() + ":\n" + ex);
            }
        }
    }

    public Long count() {
        Long c = null;
        String sql = "SELECT COUNT(ID) AS TOTAL FROM TB_TEMP_BEN_PASA";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = rs.getLong("TOTAL");
            }
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(this.getClass().getName() + ":\n" + ex);
                }
            }
        }
        return c;
    }

    public void update(TempBenPASA modelo) {
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("UPDATE TB_TEMP_BEN_PASA set ok=? where id=?");
            pst.setInt(1, 1);
            //where
            pst.setLong(2, modelo.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        }
    }

    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.err.println(this.getClass().getName() + ":\n" + ex);
        }
    }
}
