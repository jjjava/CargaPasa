package org.pasa.sispasa.cargapasa.load;

import org.pasa.sispasa.cargapasa.dao.AdesaoPlanoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.GrauParentescoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.PlanoDAOImpl;
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
    private final PlanoDAOImpl planoDAO;
    private final AdesaoPlanoDAOImpl adesaoPlanoDAO;
    private final UsuarioPlanoDAOImpl usuarioPlanoDAO;
    private final GrauParentescoDAOImpl grauParentescoDAO;

    public CargaEntidadeUsuario() {
        this.planoDAO = new PlanoDAOImpl();
        this.adesaoPlanoDAO = new AdesaoPlanoDAOImpl();
        this.grauParentescoDAO = new GrauParentescoDAOImpl();
        this.usuarioPlanoDAO = new UsuarioPlanoDAOImpl();
    }

    public Long newUsuarioPlano(TempBenPASA modeloBenef, Integer indTituRespPag, Long idParticipante, Long idAdesao) {
        return newUsuarioPlano(modeloBenef, indTituRespPag, idParticipante,idAdesao, null);
    }

    public Long newUsuarioPlano(TempBenPASA modeloBenef, Integer indTituRespPag,
            Long idParticipante, Long idAdesao,Long idUserTitular) {

        usuarioPlano = new UsuarioPlano();
        this.setType(modeloBenef);
        this.createCarteirinha(modeloBenef);
        usuarioPlano.setIndTitularResponsavelPagamento(indTituRespPag);
        usuarioPlano.setIdParticipante(idParticipante);
        usuarioPlano.setIdUsuarioTitularPlano(idUserTitular);
        usuarioPlano.setIdAdesaoPlano(idAdesao);

        Long idGP = grauParentescoDAO.getId(modeloBenef.getGrauParentesco());
        if (null != idGP) {
            usuarioPlano.setIdGrauParentesco(idGP);
        } else {
            usuarioPlano.setIdGrauParentesco(18L);
        }
        usuarioPlano.setIdUsuario(CargaPasaCommon.USER_CARGA);
        usuarioPlano.setDataInclusaoSistema(DateUtil.obterDataAtual());
        return usuarioPlanoDAO.save(usuarioPlano);
    }

    private void setType(TempBenPASA modeloBenef) {
        if (modeloBenef.getTipoBeneficiario().equalsIgnoreCase("A")) {
            usuarioPlano.setIdTipoUsario(0L);
            usuarioPlano.setStatusUsuario(1);
            usuarioPlano.setIdVinculo(1L);
            return;
        }
        if (modeloBenef.getTipoBeneficiario().equalsIgnoreCase("B")) {
            usuarioPlano.setIdTipoUsario(0L);
            usuarioPlano.setStatusUsuario(2);
            usuarioPlano.setIdVinculo(1L);
            return;
        }
        if (modeloBenef.getTipoBeneficiario().equalsIgnoreCase("D")) {
            usuarioPlano.setIdTipoUsario(1L);
            usuarioPlano.setStatusUsuario(1);
            usuarioPlano.setIdVinculo(2L);
            return;
        }
        if (modeloBenef.getTipoBeneficiario().equalsIgnoreCase("G")) {
            usuarioPlano.setIdTipoUsario(2L);
            usuarioPlano.setStatusUsuario(1);
            usuarioPlano.setIdVinculo(3L);
        }
    }
    
    private void createCarteirinha(TempBenPASA modelo) {
        usuarioPlano.setCarteirinha(modelo.getEmpresa() + modelo.getMatriculaPasa() + modelo.getCodBeneficiario());
    }
}
