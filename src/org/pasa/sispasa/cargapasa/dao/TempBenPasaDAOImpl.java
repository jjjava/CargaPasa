package org.pasa.sispasa.cargapasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.pasa.sispasa.cargapasa.connection.ConnectionSQLServer;
import org.pasa.sispasa.cargapasa.map.MapaCampos;
import org.pasa.sispasa.cargapasa.model.TempBenPASA;

/**
 *
 * @author Hudson Schumaker
 */
public class TempBenPasaDAOImpl {

    private final Connection conn;

    public TempBenPasaDAOImpl() {
        conn = ConnectionSQLServer.getConexao();
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
                    + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            
            
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

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
}
