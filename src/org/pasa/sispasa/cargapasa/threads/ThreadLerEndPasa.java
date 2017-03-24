
package org.pasa.sispasa.cargapasa.threads;

import org.pasa.sispasa.cargapasa.io.LerArquivoEndPasa;

/**
 *
 * @author Hudson Schumaker
 */
public class ThreadLerEndPasa implements Runnable {

    private final int ini;
    private final int loteLines;

    public ThreadLerEndPasa(int ini, int loteLines) {
        this.ini = ini;
        this.loteLines = loteLines;
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        new LerArquivoEndPasa().lerArquivo(ini, loteLines);
    }
}
