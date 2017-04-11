package org.pasa.sispasa.cargapasa.load;

import java.util.Date;
import java.util.List;
import org.pasa.sispasa.cargapasa.dao.AdesaoPlanoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.AssociadoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.EmpresaDAOImpl;
import org.pasa.sispasa.cargapasa.dao.FuncionarioDAOImpl;
import org.pasa.sispasa.cargapasa.dao.PessoaDAOImpl;
import org.pasa.sispasa.cargapasa.dao.PlanoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.TempBenPasaDAOImpl;
import org.pasa.sispasa.cargapasa.model.Adesao;
import org.pasa.sispasa.cargapasa.model.Associado;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaEntidadeAssociado {

    private Associado associado;

    private final TempBenPasaDAOImpl daoBen;
    private final PlanoDAOImpl planoDAO;
    private final PessoaDAOImpl pessoaDAO;
    private final EmpresaDAOImpl empresaDAO;
    private final AssociadoDAOImpl associadoDAO;
    private final TempBenPasaDAOImpl tempBenPasaDAO;
    private final AdesaoPlanoDAOImpl adesaoPlanoDAO;
    private final FuncionarioDAOImpl funcionarioDAO;
    private final CargaEntidadeUsuario cargaEntidadeUsuario;
    private final CargaEntidadeParticipante cargaEntidadeParticipante;

    public CargaEntidadeAssociado() {
        this.planoDAO = new PlanoDAOImpl();
        this.pessoaDAO = new PessoaDAOImpl();
        this.empresaDAO = new EmpresaDAOImpl();
        this.associadoDAO = new AssociadoDAOImpl();
        this.tempBenPasaDAO = new TempBenPasaDAOImpl();
        this.adesaoPlanoDAO = new AdesaoPlanoDAOImpl();
        this.funcionarioDAO = new FuncionarioDAOImpl();
        this.cargaEntidadeUsuario = new CargaEntidadeUsuario();
        this.cargaEntidadeParticipante = new CargaEntidadeParticipante();
        this.daoBen = new TempBenPasaDAOImpl();
    }

    public void newAssociado(TempBenPASA modeloBenef, String tpAssociado) {

        Long idFuncionario = funcionarioDAO.getIdByMatriculaOrgiem(modeloBenef.getMatriculaOrigem(), modeloBenef.getEmpresaOrigem());
        if (null != idFuncionario) {
            System.out.println("Achou Funcionario: " + idFuncionario);
            associado = new Associado();
            associado.setIdFuncionario(idFuncionario);
            associado.setTipoAssociado(tpAssociado);

            //CRIAR PARTICIPANTE
            Long idParticipante = cargaEntidadeParticipante.newParticipante(modeloBenef);
            if (null != idParticipante) {
                associado.setIdParticipante(idParticipante);
            }

            //ATRIBUTOS
            this.setAtributos(modeloBenef);

            //MATRICULAS
            associado.setMatriculaPasa(modeloBenef.getEmpresa() + modeloBenef.getMatriculaPasa());
            associado.setMatriculaValiaParticipante(modeloBenef.getMatriculaParticipante());
            associado.setMatriculaValiaRepresentante(modeloBenef.getMatriculaRepresentanteLegal());

            //CARGA
            associado.setId(CargaPasaCommon.USER_CARGA);
            associado.setDataUltimaAlteracao(DateUtil.obterDataAtual());

            //SALVAR ASSOCIADO
            associadoDAO.salve(associado);

            //AGREGADOs E USUARIOs
            this.agregadosUsuarios(modeloBenef, idParticipante);
        }
    }

    private void agregadosUsuarios(TempBenPASA modeloBenef, Long idAssoc) {
        List<TempBenPASA> listaUsuariosTitulares = tempBenPasaDAO.getUsuariosTitulares(modeloBenef.getEmpresaOrigem(), modeloBenef.getMatriculaOrigem(), modeloBenef.getTipoBeneficiario());
        for (TempBenPASA usuarioTitular : listaUsuariosTitulares) {
            Long idUsuarioTitular = cargaEntidadeUsuario.newUsuarioPlano(usuarioTitular, CargaPasaCommon.VERDADEIRO, idAssoc);
            List<TempBenPASA> listaUsuariosAgregados = tempBenPasaDAO.getUsuarios(usuarioTitular.getEmpresaOrigem(), usuarioTitular.getMatriculaOrigem());
            for (TempBenPASA usuarioAgreado : listaUsuariosAgregados) {
                Long idParticipante = cargaEntidadeParticipante.newParticipante(usuarioAgreado);
                if (null != idParticipante) {
                    cargaEntidadeUsuario.newUsuarioPlano(usuarioAgreado, CargaPasaCommon.VERDADEIRO, idParticipante, idUsuarioTitular);
                }
            }
        }
    }

    private Long getPlano(TempBenPASA modeloBenef) {
        return planoDAO.getId(modeloBenef.getPlano());
    }

    private void setAtributos(TempBenPASA modeloBenef) {
        associado.setDataAdmissaoGrupo(DateUtil.toDate(modeloBenef.getDataAdmissao()));
        //associado.setDataAssociacao(DateUtil.toDate(modeloBenef.getDataAdesao()));
        this.findDataAssociacao(modeloBenef);
        associado.setIdTaxaAssociado(1L);
        associado.setIdSituacaoAssociado(3L);
        associado.setTipoRespPagamento("T");//
        associado.setCategoria(modeloBenef.getCategoriaPASA());
    }

    private void findDataAssociacao(TempBenPASA modeloBenef) {

        List<TempBenPASA> list = daoBen.getTitular(modeloBenef.getEmpresa(), modeloBenef.getMatriculaOrigem(), modeloBenef.getTipoBeneficiario());

        if (list.size() > 1) {
            TempBenPASA t1 = list.get(0);
            TempBenPASA t2 = list.get(1);
            Date d1 = DateUtil.toDate(t1.getDataAdesao());
            Date d2 = DateUtil.toDate(t2.getDataAdesao());

            if (d1.after(d2)) {
                associado.setDataAssociacao(d1);
                daoBen.update(t2);
                daoBen.update(t1);
            } else {
                associado.setDataAssociacao(d2);
                daoBen.update(t1);
                daoBen.update(t2);
            }
        } else {
            associado.setDataAssociacao(DateUtil.toDate(modeloBenef.getDataAdesao()));
            daoBen.update(modeloBenef);
        }
    }
}
