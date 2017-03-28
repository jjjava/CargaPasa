package org.pasa.sispasa.cargapasa.load;

import org.pasa.sispasa.cargapasa.dao.EmpresaDAOImpl;
import org.pasa.sispasa.cargapasa.dao.FuncionarioDAOImpl;
import org.pasa.sispasa.cargapasa.model.Associado;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaEntidadeAssociado {

    private Associado associado;

    private final EmpresaDAOImpl empresaDAO;
    private final FuncionarioDAOImpl funcionarioDAO;

    public CargaEntidadeAssociado() {
        this.empresaDAO = new EmpresaDAOImpl();
        this.funcionarioDAO = new FuncionarioDAOImpl();
    }

    public void newAssociado(TempBenPASA modeloBenef) {
        associado = new Associado();

        //CRIAR PARTICIPANTE
        Long idParticipante = new CargaEntidadeParticipante().newParticipante(modeloBenef);
        if (null != idParticipante) {
            associado.setIdParticipante(idParticipante);
        }

        //FUNCIONARIO
        this.setFuncionario(modeloBenef);

        //MATRICULAS
        associado.setMatriculaPasa(modeloBenef.getMatriculaPasa());
        associado.setMatriculaValiaParticipante(modeloBenef.getMatriculaParticipante());
        associado.setMatriculaValiaRepresentante(modeloBenef.getMatriculaRepresentanteLegal());

        //CARGA
        associado.setId(CargaPasaCommon.USER_CARGA);
        associado.setDataUltimaAlteracao(DateUtil.obterDataAtual());

    }

    public void setAtributos(TempBenPASA modeloBenef) {
        associado.setDataAdmissaoGrupo(DateUtil.toDate(modeloBenef.getDataAdmissao()));
        associado.setIdTaxaAssociado(1L);
        associado.setIdSituacaoAssociado(3L);
    }

    public void setFuncionario(TempBenPASA modeloBenef) {
        Long idFunc = funcionarioDAO.getId(empresaDAO.getByCdVale(modeloBenef.getEmpresa()),
                modeloBenef.getMatriculaOrigem());

        if (null != idFunc) {
            associado.setIdFuncionario(idFunc);
        }
    }
}
