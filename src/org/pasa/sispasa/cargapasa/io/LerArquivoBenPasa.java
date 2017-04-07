package org.pasa.sispasa.cargapasa.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import org.pasa.sispasa.cargapasa.bean.TempBenPasaBeanImpl;
import org.pasa.sispasa.cargapasa.enumeration.EnumBanco;
import org.pasa.sispasa.cargapasa.map.MapaCampos;
import org.pasa.sispasa.cargapasa.map.MapaCamposBen;
import org.pasa.sispasa.cargapasa.map.PosicaoCampo;
import org.pasa.sispasa.cargapasa.load.TempBenPASA;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class LerArquivoBenPasa {

    private PosicaoCampo campo;
    private final Map<String, PosicaoCampo> mapa;
    private final TempBenPasaBeanImpl modeloBean;
    private int ini;
    private int loteLines;

    public LerArquivoBenPasa() {
        this.modeloBean = new TempBenPasaBeanImpl();
        this.mapa = new MapaCamposBen().getMapa();
    }

    public void lerArquivo(int ini, int loteLines) {
        this.ini = ini;
        this.loteLines = loteLines;
        lerArquivo(CargaPasaCommon.FILE_BEN);
    }

    private void lerArquivo(String path) {
        lerArquivo(new File(path));
    }

    private void lerArquivo(File file) {
        String out = "";
        try {
            RandomAccessFile aFile = new RandomAccessFile(file, "r");
            FileChannel inChannel = aFile.getChannel();
            for (int i = 0; i < loteLines; i++) {
                MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, ini, CargaPasaCommon.LINE_TAM_1);
                buffer.load();
                out = "";
                for (int j = 0; j < CargaPasaCommon.LINE_TAM_1; j++) {
                    out = out + ((char) buffer.get());
                }
                ini = ini + CargaPasaCommon.LINE_TAM_2;
                buffer.clear();
                modeloBean.save(parseCampos(out));
            }
            inChannel.close();
            aFile.close();
        } catch (FileNotFoundException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        } catch (IOException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        } finally {
           //modeloBean.closeConnection();
        }
    }

    private TempBenPASA parseCampos(String line) {
        //NORMALIZACOES DA LINHA
        line = acerta400Pos(line);
        line = StringUtil.removeCharsEspeciais(line);
        line = normalizaLinha(line);
        TempBenPASA modelo = new TempBenPASA();
        try {
            campo = (PosicaoCampo) mapa.get(MapaCampos.EMPRESA);
            modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.MATRICULA);
            modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.COD_BENEFICIARIO);
            modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DIREITO_AMS_CREDENCIAMENTO);
            modelo.setDireitoAMSCredenciamento(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DIREITO_AMS_REEMBOLSO);
            modelo.setDireitoAmsReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DATA_VALIDADE_CREDENCIADO);
            modelo.setDataValidadeCredenciado(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DATA_VALIDADE_REEMBOLSO);
            modelo.setDataValidadeReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DATA_DE_ATUALIZACAO);
            modelo.setDataDeAtualizacao(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.NOME_BENEFICIARIO_ABREVIADO);
            modelo.setNomeBeneficiarioAbreviado(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.CODIGO_CR);
            modelo.setCodigoCR(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.ORGAO_PESSOAL);
            modelo.setOrgaoPessoal(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.VINCULO);
            modelo.setVinculo(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.PLANO);//Acerto Plano
            modelo.setPlano(acertaPlano(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim()));
            campo = (PosicaoCampo) mapa.get(MapaCampos.FAIXA_NIVEL);
            modelo.setFaixaNivel(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DATA_NASCIMENTO);
            modelo.setDataNascimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DIREITO_ABATER_IR);
            modelo.setDireitoAbaterIR(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.NUCLEO_DA_AMS);
            modelo.setNucleoDaAms(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.AGENCIA_BANCARIA);
            modelo.setAgenciaBancaria(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

            //NORMALIZA CODIGO BANCARIO.
            campo = (PosicaoCampo) mapa.get(MapaCampos.BANCO);
            modelo.setBanco(normalizaBanco(line.substring(campo.getInicioCampo(), campo.getFimCampo())));
            campo = (PosicaoCampo) mapa.get(MapaCampos.CONTA_CORRENTE);
            modelo.setContaCorrente(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DATA_ADMISSAO);
            modelo.setDataAdmissao(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.GRAU_PARENTESCO);
            
            modelo.setGrauParentesco(acertaGrauParentesco(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim()));
            campo = (PosicaoCampo) mapa.get(MapaCampos.FINACEIRA);
            modelo.setFinanceira(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.CONTRATO_TRABALHO);
            modelo.setContratoTrabalho(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.SEXO);
            modelo.setSexo(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.EMPRESA_ATUALIZADOR);
            modelo.setEmpresaAtualizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.MATRICULA_ATUALIZADOR);
            modelo.setMatriculaAtulizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.TIPO_BENEFICIARIO);
            modelo.setTipoBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.CODIGO_DIREITO_PASA);
            modelo.setCodigoDireitoPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.GRAU_ESCOLARIDADE);
            modelo.setGrauEscolaridade(acertaNivelEscolaridade(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim()));
            campo = (PosicaoCampo) mapa.get(MapaCampos.INDICAR_CONCLUSAO);
            modelo.setIndicadorConclusao(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DATA_FALECIMENTO);
            modelo.setDataFalecimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.MATRICULA_PASA);
            modelo.setMatriculaPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.NOME_DA_MAE);
            modelo.setNomeDaMae(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.PIS);
            modelo.setPis(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.CPF);
            modelo.setCpf(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.EMPRESA_ORIGEM);
            modelo.setEmpresaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.MATRICULA_ORIGEM);
            modelo.setMatriculaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.EMPRESA_PEOPLE);
            modelo.setEmpresaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.MATRICULA_PEOPLE);
            modelo.setMatriculaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.UNIDADE_DE_CONTROLE);
            modelo.setUnidadeDeControle(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.CENTRO_DE_CUSTO);
            modelo.setCentroDeCusto(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.MATRICULA_PARTICIPANTE);
            modelo.setMatriculaParticipante(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.MATRICULA_REPRESENTANTE_LEGAL);
            modelo.setMatriculaRepresentanteLegal(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

            // CATEGOARIA
            campo = (PosicaoCampo) mapa.get(MapaCampos.CATEGORIA_PASA);
            modelo.setCategoriaPASA(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

            campo = (PosicaoCampo) mapa.get(MapaCampos.DATA_ADESAO);
            modelo.setDataAdesao(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DATA_INICIO_CARENCIA);
            modelo.setDataInicioCarencia(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.NOME_BENEFICIARIO);
            modelo.setNomeCompleto(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

            campo = (PosicaoCampo) mapa.get(MapaCampos.DIAS_DE_CARENCIA);
            modelo.setDiasDeCarencia(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.CODIGO_NACIONAL_SAUDE);
            modelo.setCodigoNacionalDeSaude(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.DECLARACAO_NASCIDO_VIVO);
            modelo.setDeclaracaoNascidoVivo(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

        } catch (Exception ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        }
        return modelo;
    }

    private String acerta400Pos(String line) {
        while (line.length() < 400) {
            line = line + " ";
        }
        return line;
    }

    private String normalizaLinha(String line) {
        line = " " + line;
        return line;
    }

    private String normalizaBanco(String s) {
        s = s.replaceFirst("^0+(?!$)", "");
        s = s.trim();//A pediddo do Allan
        s = s.toUpperCase();
        if (EnumBanco.existe(s)) {
            return s;
        } else {
            return "";
        }
    }
    
    private String acertaNivelEscolaridade(String nvlesc){
        return acertaPlano(nvlesc);
    }
    
    private String acertaGrauParentesco(String grau){
        if (grau.equals("") || grau.equals(" ") || grau.equals("  ")) {
            return "P";
        }
        return grau;
    }

    private String acertaPlano(String plano) {
        if (plano.equals("") || plano.equals(" ") || plano.equals("  ")) {
            return "0";
        }
        return plano;
    }
}
