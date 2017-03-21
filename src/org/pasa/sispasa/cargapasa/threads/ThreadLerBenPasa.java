
package org.pasa.sispasa.cargapasa.threads;

import org.pasa.sispasa.cargapasa.io.LerArquivoBenPasa;

/**
 *
 * @author Hudson Schumaker
 */
public class ThreadLerBenPasa implements Runnable{

    private final int ini;
    private final int loteLines;
    
    public ThreadLerBenPasa(int ini, int loteLines){
        this.ini = ini;
        this.loteLines = loteLines;
    }
    
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        new LerArquivoBenPasa().lerArquivo(ini, loteLines);
    }
}
