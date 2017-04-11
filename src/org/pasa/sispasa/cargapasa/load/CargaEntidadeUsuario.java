package org.pasa.sispasa.cargapasa.load;

import org.pasa.sispasa.cargapasa.dao.AdesaoPlanoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.GrauParentescoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.PlanoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.UsuarioPlanoDAOImpl;
import org.pasa.sispasa.cargapasa.model.Adesao;
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

    public Long newUsuarioPlano(TempBenPASA modeloBenef, Integer indTituRespPag,
            Long idParticipante, Long idUserTitular) {

        usuarioPlano = new UsuarioPlano();
        this.setType(modeloBenef);
        usuarioPlano.setIndTitularResponsavelPagamento(indTituRespPag);
        usuarioPlano.setIdParticipante(idParticipante);
        usuarioPlano.setIdUsuarioTitularPlano(idUserTitular);

        //ADESAO
        usuarioPlano.setIdAdesaoPlano(newAdesao(modeloBenef, idUserTitular));

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
            return;
        }
        if (modeloBenef.getTipoBeneficiario().equalsIgnoreCase("B")) {
            usuarioPlano.setIdTipoUsario(0L);
            usuarioPlano.setStatusUsuario(2);
            return;
        }
        if (modeloBenef.getTipoBeneficiario().equalsIgnoreCase("D")) {
            usuarioPlano.setIdTipoUsario(1L);
            usuarioPlano.setStatusUsuario(1);
            return;
        }
        if (modeloBenef.getTipoBeneficiario().equalsIgnoreCase("G")) {
            usuarioPlano.setIdTipoUsario(2L);
            usuarioPlano.setStatusUsuario(1);
        }
    }

    private Long newAdesao(TempBenPASA modeloBenef, Long idAssoc) {
        Adesao adesao = new Adesao();
        adesao.setIdAssociado(idAssoc);
        Long idPlano = getPlano(modeloBenef);
        if (null != idPlano) {
            adesao.setIdPlano(idPlano);
        } else {
            return null;
        }
        adesao.setIdUsuario(CargaPasaCommon.USER_CARGA);
        adesao.setDataInclusaoSistema(DateUtil.toDate(modeloBenef.getDataAdesao()));
        return adesaoPlanoDAO.save(adesao);
    }

    private Long getPlano(TempBenPASA modeloBenef) {
        return planoDAO.getId(modeloBenef.getPlano());
    }
    
    private void createCarteirinha(TempBenPASA modelo){
        usuarioPlano.setCarteirinha(modelo.getEmpresa()+modelo.getMatriculaPasa()+modelo.getCodBeneficiario());
    }
}
