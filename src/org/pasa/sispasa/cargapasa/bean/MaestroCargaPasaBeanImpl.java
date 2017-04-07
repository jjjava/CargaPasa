package org.pasa.sispasa.cargapasa.bean;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.pasa.sispasa.cargapasa.dao.TempBenPasaDAOImpl;
import org.pasa.sispasa.cargapasa.load.CargaMapeiaEntidadesThread;
import org.pasa.sispasa.cargapasa.threads.ThreadLerBenPasa;
import org.pasa.sispasa.cargapasa.threads.ThreadLerEndPasa;
import org.pasa.sispasa.cargapasa.util.ArquivoUtil;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.Sistema;

/**
 *
 * @author Hudson Schumaker
 */
public class MaestroCargaPasaBeanImpl {

    private final TempBenPasaDAOImpl daoBen;

    public MaestroCargaPasaBeanImpl() {
        this.daoBen = new TempBenPasaDAOImpl();
    }

    public void inicio() {
        this.readBenFile();
        this.readEndFile();
        System.err.println("cabou");
        //this.mapearEntidades();
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

    private void mapearEntidades() {
        ExecutorService executor = Executors.newFixedThreadPool(Sistema.getNumberProcessors());
        long qtdRegistros = daoBen.count();
        System.out.println(qtdRegistros);
        if (qtdRegistros > 2001) {
            long lote = ArquivoUtil.getNumeroLinhasLote(qtdRegistros);
            long ini = 1;
            long fim = lote;
            try {
                for (int k = 0; k < Sistema.getNumberProcessors(); k++) {
                    if ((Sistema.getNumberProcessors() - k) == 1) {
                        fim = fim + ArquivoUtil.getNumeroLinhasResto(qtdRegistros);
                    }
                    executor.execute(new CargaMapeiaEntidadesThread(ini, fim, " Thread_" + (k + 1)));
                    ini = fim;
                    fim = fim + lote;
                }
                executor.shutdown();
                while (!executor.isTerminated()) {
                }
            } catch (Exception ex) {
                System.err.println(this.getClass().getName() + "\n" + ex);
            }
        } else {
            long ini = 1;
            long fim = qtdRegistros;
            try {
                executor.execute(new CargaMapeiaEntidadesThread(ini, fim, " Thread"));
            } catch (Exception ex) {
                System.err.println(this.getClass().getName() + "\n" + ex);
            }
        }
    }
}
