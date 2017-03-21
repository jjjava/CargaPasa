/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
