package org.pasa.sispasa.cargapasa.bean;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.pasa.sispasa.cargapasa.threads.ThreadLerBenPasa;
import org.pasa.sispasa.cargapasa.threads.ThreadLerEndPasa;
import org.pasa.sispasa.cargapasa.util.ArquivoUtil;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.Sistema;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaPasa {

    public CargaPasa() {
    }

    public void inicio() {
        readBenFile();
        readEndFile();
        mapear();
    }

    private void readBenFile() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(Sistema.getNumberProcessors());
            int lote = ArquivoUtil.getNumeroLinhasLote(ArquivoUtil.getNumerosLinhaArquivo(CargaPasaCommon.FILE_BEN));
            int loteLines = lote;
            lote = lote * CargaPasaCommon.LINE_TAM_2;
            int ini = 0;
            int fim = lote;
            for (int i = 0; i < Sistema.getNumberProcessors(); i++) {
                executor.execute(new ThreadLerBenPasa(ini, loteLines));
                ini = fim;
                fim = fim + lote;
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
        } catch (IOException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
        }

    }
    
    private void readEndFile() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(Sistema.getNumberProcessors());
            int lote = ArquivoUtil.getNumeroLinhasLote(ArquivoUtil.getNumerosLinhaArquivo(CargaPasaCommon.FILE_END));
            int loteLines = lote;
            lote = lote * CargaPasaCommon.LINE_TAM_4;
            int ini = 0;
            int fim = lote;
            for (int i = 0; i < Sistema.getNumberProcessors(); i++) {
                executor.execute(new ThreadLerEndPasa(ini, loteLines));
                ini = fim;
                fim = fim + lote;
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
        } catch (IOException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);

        }
    }

    private void mapear() {

    }
}
