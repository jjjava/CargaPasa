package org.pasa.sispasa.cargapasa.model;

import java.util.Date;
import org.pasa.sispasa.cargapasa.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class Telefone {

    private Long id;
    private String ddd;
    private String numeroTelefone;
    private String ramal;
    private Integer indAtivo;
    private Long idUsuario;
    private Date dataUltimaAtualizacao;
    private TipoTelefone tipoTelefone;

    public Telefone() {
        this.indAtivo = 1;
        this.dataUltimaAtualizacao = DateUtil.obterDataAtual();
    }

    public Telefone(Long id) {
        this.id = id;
        this.indAtivo = 1;
        this.dataUltimaAtualizacao = DateUtil.obterDataAtual();
    }
}
