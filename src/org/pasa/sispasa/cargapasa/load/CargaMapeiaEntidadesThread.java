package org.pasa.sispasa.cargapasa.load;

import org.pasa.sispasa.cargapasa.dao.TempBenPasaDAOImpl;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaMapeiaEntidadesThread implements Runnable {

    private final long ini;
    private final String nome;
    private final long qtdRegistros;
    private final TempBenPasaDAOImpl benDAO;
    private final CargaEntidadeAssociado cargaEntidadeAssociado;

    public CargaMapeiaEntidadesThread(long ini, long qtdRegistros, String nome) {
        this.ini = ini;
        this.nome = nome;
        this.qtdRegistros = qtdRegistros;
        this.benDAO = new TempBenPasaDAOImpl();
        this.cargaEntidadeAssociado = new CargaEntidadeAssociado();
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    private void mapearEntidades() {
        try {
            for (Long k = ini; k < qtdRegistros; k++) {
                try {
                    TempBenPASA modeloBenef = benDAO.get(k);
                    if (null != modeloBenef) {
                        if (1 != modeloBenef.getOk()) {
                            if (modeloBenef.getTipoBeneficiario().equalsIgnoreCase(CargaPasaCommon.USUARIO)) {
                                cargaEntidadeAssociado.newAssociado(modeloBenef, "A");//Atencao
                            }
                            if(modeloBenef.getTipoBeneficiario().equalsIgnoreCase(CargaPasaCommon.ASSOCIADO)){
                                //
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.err.println(nome + " " + this.getClass().getName() + ":\n" + ex);
                }
            }
        } catch (Exception ex) {
            System.err.println(nome + " " + this.getClass().getName() + ":\n" + ex);
        }
    }

    @Override
    public void run() {
        this.mapearEntidades();
    }
}
