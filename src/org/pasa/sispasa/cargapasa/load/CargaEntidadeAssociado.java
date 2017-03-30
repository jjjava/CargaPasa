package org.pasa.sispasa.cargapasa.load;

import java.util.List;
import org.pasa.sispasa.cargapasa.dao.AdesaoPlanoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.AssociadoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.EmpresaDAOImpl;
import org.pasa.sispasa.cargapasa.dao.FuncionarioDAOImpl;
import org.pasa.sispasa.cargapasa.dao.PessoaDAOImpl;
import org.pasa.sispasa.cargapasa.dao.PlanoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.TempBenPasaDAOImpl;
import org.pasa.sispasa.cargapasa.enumeration.EnumTipoRespPagamento;
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
    }

    public void newAssociado(TempBenPASA modeloBenef, String tpAssociado) {
        
        Long idPessoa = pessoaDAO.getIdByNome(modeloBenef.getNomeCompleto());
        if (null != idPessoa) {
            Long idFuncionario = funcionarioDAO.getId(idPessoa);
            System.out.println(idFuncionario+" "+modeloBenef.getNomeCompleto());
            if (null != idFuncionario) {
                System.out.println("Achou Funcionario: "+idFuncionario);
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
                //FUNCIONARIO
                this.setFuncionario(modeloBenef);

                //MATRICULAS
                associado.setMatriculaPasa(modeloBenef.getMatriculaPasa());
                associado.setMatriculaValiaParticipante(modeloBenef.getMatriculaParticipante());
                associado.setMatriculaValiaRepresentante(modeloBenef.getMatriculaRepresentanteLegal());

                //CARGA
                associado.setId(CargaPasaCommon.USER_CARGA);
                associado.setDataUltimaAlteracao(DateUtil.obterDataAtual());

                //SALVAR ASSOCIADO
                associadoDAO.salve(associado);

                //CRIAR ADESAO
                Long idAdesao = newAdesao(modeloBenef, idParticipante);

                //CRIAR USUARIO PLANO
                cargaEntidadeUsuario.newUsuarioPlano(modeloBenef, CargaPasaCommon.VERDADEIRO,
                        idParticipante, idParticipante);

                //AGREGADOs E USUARIOs
                this.agregadosUsuarios(modeloBenef, idParticipante, idAdesao);
            }
        }
    }

    private void agregadosUsuarios(TempBenPASA modeloBenef, Long idAssoc, Long idAdesao) {
        List<TempBenPASA> list = tempBenPasaDAO.getUsuarios(modeloBenef.getEmpresa(), modeloBenef.getMatricula());

        for (TempBenPASA t : list) {
            Long idParticipante = cargaEntidadeParticipante.newParticipante(t);
            if (null != idParticipante) {
                cargaEntidadeUsuario.newUsuarioPlano(modeloBenef, CargaPasaCommon.VERDADEIRO,
                        idParticipante, idAssoc);
            }
        }
    }

    private Long newAdesao(TempBenPASA modeloBenef, Long idAssoc) {
        Adesao adesao = new Adesao();
        adesao.setIdAssociado(idAssoc);
        Long idPlano = getPlano(modeloBenef);

        adesao.setIdPlano(idPlano);

        adesao.setIdUsuario(CargaPasaCommon.USER_CARGA);
        adesao.setDataInclusaoSistema(DateUtil.obterDataAtual());
        return adesaoPlanoDAO.save(adesao);
    }

    private Long getPlano(TempBenPASA modeloBenef) {
        return planoDAO.getId(modeloBenef.getPlano());
    }

    private void setAtributos(TempBenPASA modeloBenef) {
        associado.setDataAdmissaoGrupo(DateUtil.toDate(modeloBenef.getDataAdmissao()));
        associado.setIdTaxaAssociado(2L);
        associado.setIdSituacaoAssociado(3L);
        associado.setTipoRespPagamento("T");//
        associado.setCategoria(modeloBenef.getCategoriaPASA());
    }

    private void setFuncionario(TempBenPASA modeloBenef) {
        Long idFunc = funcionarioDAO.getId(empresaDAO.getByCdVale(modeloBenef.getEmpresaOrigem()),
                modeloBenef.getMatriculaOrigem());

        if (null != idFunc) {
            associado.setIdFuncionario(idFunc);
        } else {
            System.out.println("Nao achou funcionario");
            associado.setIdFuncionario(-1L);
        }
    }
}
