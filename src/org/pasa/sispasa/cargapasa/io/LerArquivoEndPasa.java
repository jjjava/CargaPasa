package org.pasa.sispasa.cargapasa.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import org.pasa.sispasa.cargapasa.bean.TempEndPasaBeanImpl;
import org.pasa.sispasa.cargapasa.map.MapaCampos;
import org.pasa.sispasa.cargapasa.map.MapaCamposEnd;
import org.pasa.sispasa.cargapasa.map.PosicaoCampo;
import org.pasa.sispasa.cargapasa.load.TempEndPASA;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class LerArquivoEndPasa {

    private PosicaoCampo campo;
    private final Map<String, PosicaoCampo> mapa;
    private final TempEndPasaBeanImpl modeloBean;
    private int ini;
    private int loteLines;

    public LerArquivoEndPasa() {
        this.modeloBean = new TempEndPasaBeanImpl();
        this.mapa = new MapaCamposEnd().getMapa();
    }

    public void lerArquivo(int ini, int loteLines) {
        this.ini = ini;
        this.loteLines = loteLines;
        lerArquivo(CargaPasaCommon.FILE_END);
    }

    private void lerArquivo(String path) {
        lerArquivo(new File(path));
    }

    public void lerArquivo(File file) {
        String out = "";
        try {
            RandomAccessFile aFile = new RandomAccessFile(file, "r");
            FileChannel inChannel = aFile.getChannel();
            for (int i = 0; i < loteLines; i++) {
                MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, ini, CargaPasaCommon.LINE_TAM_3);
                buffer.load();
                out = "";
                for (int j = 0; j < CargaPasaCommon.LINE_TAM_3; j++) {
                    out = out + ((char) buffer.get());
                }
                ini = ini + CargaPasaCommon.LINE_TAM_4;
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

    private TempEndPASA parseCampos(String line) {
        //NORMALIZACOES DA LINHA
        line = acerta190Pos(line);
        line = StringUtil.removeCharsEspeciais(line);
        line = normalizaLinha(line);
        TempEndPASA modelo = new TempEndPASA();
        try {
            //ENDERECO - TELEFONES
            campo = (PosicaoCampo) mapa.get(MapaCampos.EMPRESA);
            modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.MATRICULA);
            modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.COD_BENEFICIARIO);
            modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.TELEFONE1);
            modelo.setTelefone1(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.TELEFONE2);
            modelo.setTelefone2(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.TELEFONE3);
            modelo.setTelefone3(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.ENDERECO);
            modelo.setEndereco(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.BAIRRO);
            modelo.setBairro(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(MapaCampos.CIDADE);
            modelo.setCidade(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

            campo = (PosicaoCampo) mapa.get(MapaCampos.UF);
            modelo.setUf(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

            campo = (PosicaoCampo) mapa.get(MapaCampos.CEP);
            modelo.setCep(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

            campo = (PosicaoCampo) mapa.get(MapaCampos.EMAIL);
            modelo.setEmail(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

        } catch (Exception ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        }
        return modelo;
    }

    private String acerta190Pos(String line) {
        while (line.length() < 190) {
            line = line + " ";
        }
        return line;
    }

    private String normalizaLinha(String line) {
        line = " " + line;
        return line;
    }
}
