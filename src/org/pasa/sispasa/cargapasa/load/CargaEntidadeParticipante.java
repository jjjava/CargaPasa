package org.pasa.sispasa.cargapasa.load;

import org.pasa.sispasa.cargapasa.dao.DocumentoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.EnderecoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.EstadoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.MunicipioDAOImpl;
import org.pasa.sispasa.cargapasa.dao.NivelEscolaridadeDAOImpl;
import org.pasa.sispasa.cargapasa.dao.ParticipanteDAOImpl;
import org.pasa.sispasa.cargapasa.dao.TempEndPasaDAOImpl;
import org.pasa.sispasa.cargapasa.enumeration.EnumTipoDocumento;
import org.pasa.sispasa.cargapasa.model.Documento;
import org.pasa.sispasa.cargapasa.model.Endereco;
import org.pasa.sispasa.cargapasa.model.Estado;
import org.pasa.sispasa.cargapasa.model.Municipio;
import org.pasa.sispasa.cargapasa.model.Participante;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.DateUtil;
import org.pasa.sispasa.cargapasa.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaEntidadeParticipante {

    private Participante participante;

    private final EstadoDAOImpl estadoDAO;
    private final EnderecoDAOImpl enderecoDAO;
    private final TempEndPasaDAOImpl endDAO;
    private final MunicipioDAOImpl municipioDAO;
    private final DocumentoDAOImpl documentoDAO;
    private final NivelEscolaridadeDAOImpl nivelEscolaridadeDAO;
    private final ParticipanteDAOImpl participanteDAO;

    public CargaEntidadeParticipante() {
        this.estadoDAO = new EstadoDAOImpl();
        this.endDAO = new TempEndPasaDAOImpl();
        this.enderecoDAO = new EnderecoDAOImpl();
        this.municipioDAO = new MunicipioDAOImpl();
        this.documentoDAO = new DocumentoDAOImpl();
        this.nivelEscolaridadeDAO = new NivelEscolaridadeDAOImpl();
        this.participanteDAO = new ParticipanteDAOImpl();
    }

    public Long newParticipante(TempBenPASA modelo) {
        participante = new Participante();
        this.setAtributos(modelo);

        //ENDERECO
        Long idEnd = newEndereco(modelo);
        if (null == idEnd) {
            return null;
        }
        participante.setEndereco(idEnd);

        //DOCUMENTOS
        Long idDoc = newPis(modelo);
        if (null == idDoc) {
            return null;
        }
        participante.addDocumento(idDoc);

        //GRAU ESCOLARIDADE
        Long idNvlEsc = nivelEscolaridade(modelo);
        if (null == idNvlEsc) {
            return null;
        }
        participante.setNivelEscolaridade(idNvlEsc);

        //CARGA
        participante.setIdUsuario(CargaPasaCommon.USER_CARGA);
        participante.setIndAtivo(CargaPasaCommon.ATIVO);
        participante.setDataUltimaAtualizacao(DateUtil.obterDataAtual());

        return participanteDAO.save(participante);
    }

    private Long newEndereco(TempBenPASA benModelo) {
        TempEndPASA endModelo = endDAO.get(benModelo.getEmpresa(), benModelo.getMatricula(), benModelo.getCodBeneficiario());
        if (null == endModelo) {
            System.err.println("SEM ENDERECO NA TEMP.");
            return null;
        }
        Estado estado = estadoDAO.get(endModelo.getUf());
        if (null == estado) {
            System.err.println("UF NAO EXISTENTE.");
            return null;
        }
        Municipio municipio = municipioDAO.get(endModelo.getCidade());
        if (null == municipio) {
            System.err.println("CIDADE NAO ENCONTRADA.");
            return null;
        }
        participante.setEmail(endModelo.getEmail());
        Endereco endereco = new Endereco();
        endereco.setLogradouro(endModelo.getEndereco());
        endereco.setBairro(endModelo.getBairro());
        endereco.setCep(endModelo.getCep());
        endereco.setIdUsuario(CargaPasaCommon.USER_CARGA);
        endereco.setIndAtivo(CargaPasaCommon.ATIVO);
        endereco.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        endereco.setIdEstado(estado.getId());
        endereco.setIdMunicipio(municipio.getId());
        return enderecoDAO.save(endereco);
    }

    private Long newPis(TempBenPASA benModelo) {
        Documento pis = new Documento();
        pis.setNumero(benModelo.getPis());
        pis.setTipoDocumento(EnumTipoDocumento.PIS_PASEP.getIndice());
        return documentoDAO.save(pis);
    }

    private Long nivelEscolaridade(TempBenPASA benModelo) {
        return nivelEscolaridadeDAO.get(benModelo.getGrauEscolaridade());
    }

    private void setAtributos(TempBenPASA modelo) {
        participante.setSexo(modelo.getCpf());
        participante.setDataFalecimento(DateUtil.toDate(modelo.getDataFalecimento()));
        participante.setDataNascimento(DateUtil.toDate(modelo.getDataNascimento()));
        participante.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        // participante.setEmail(modelo.get);
        participante.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modelo.getIndicadorConclusao()));
        participante.setNome(modelo.getNomeCompleto());
        participante.setNomeMae(modelo.getNomeDaMae());
        participante.setSexo(modelo.getSexo());
    }
}
