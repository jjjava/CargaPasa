package org.pasa.sispasa.cargapasa.load;

import org.pasa.sispasa.cargapasa.dao.GrauParentescoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.UsuarioPlanoDAOImpl;
import org.pasa.sispasa.cargapasa.model.UsuarioPlano;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaEntidadeUsuario {

    private UsuarioPlano usuarioPlano;
    private final GrauParentescoDAOImpl grauParentescoDAO;
    private final UsuarioPlanoDAOImpl usuarioPlanoDAO;

    public CargaEntidadeUsuario() {
        this.grauParentescoDAO = new GrauParentescoDAOImpl();
        this.usuarioPlanoDAO = new UsuarioPlanoDAOImpl();
    }

    public Long newUsuarioPlano(TempBenPASA modeloBenef, Integer indTituRespPag,
            Long idParticipante, Long idUserTitular, Long idAdessao) {

        usuarioPlano = new UsuarioPlano();
        usuarioPlano.setIndTitularResponsavelPagamento(indTituRespPag);
        usuarioPlano.setIdParticipante(idParticipante);
        usuarioPlano.setIdUsuarioTitularPlano(idUserTitular);

        Long idGP = grauParentescoDAO.getId(modeloBenef.getGrauParentesco());
        if (null != idGP) {
            usuarioPlano.setIdGrauParentesco(idGP);
        }

        usuarioPlano.setIdAdesaoPlano(idAdessao);
        usuarioPlano.setIdUsuario(CargaPasaCommon.USER_CARGA);
        usuarioPlano.setDataInclusaoSistema(DateUtil.obterDataAtual());

        return usuarioPlanoDAO.save(usuarioPlano);
    }
}
