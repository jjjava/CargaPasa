package org.pasa.sispasa.cargapasa.load;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasa.cargapasa.dao.DocumentoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.EnderecoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.EstadoDAOImpl;
import org.pasa.sispasa.cargapasa.dao.MunicipioDAOImpl;
import org.pasa.sispasa.cargapasa.dao.NivelEscolaridadeDAOImpl;
import org.pasa.sispasa.cargapasa.dao.ParticipanteDAOImpl;
import org.pasa.sispasa.cargapasa.dao.TelefoneDAOImpl;
import org.pasa.sispasa.cargapasa.dao.TempEndPasaDAOImpl;
import org.pasa.sispasa.cargapasa.enumeration.EnumTipoDocumento;
import org.pasa.sispasa.cargapasa.model.Documento;
import org.pasa.sispasa.cargapasa.model.Endereco;
import org.pasa.sispasa.cargapasa.model.Estado;
import org.pasa.sispasa.cargapasa.model.Municipio;
import org.pasa.sispasa.cargapasa.model.Participante;
import org.pasa.sispasa.cargapasa.model.Telefone;
import org.pasa.sispasa.cargapasa.util.CargaPasaCommon;
import org.pasa.sispasa.cargapasa.util.DateUtil;
import org.pasa.sispasa.cargapasa.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaEntidadeParticipante {
    
    private Participante participante;
    private TempEndPASA endModelo;
    private final EstadoDAOImpl estadoDAO;
    private final TempEndPasaDAOImpl endDAO;
    private final EnderecoDAOImpl enderecoDAO;
    private final MunicipioDAOImpl municipioDAO;
    private final DocumentoDAOImpl documentoDAO;
    private final TelefoneDAOImpl telefoneDAO;
    private final ParticipanteDAOImpl participanteDAO;
    private final NivelEscolaridadeDAOImpl nivelEscolaridadeDAO;
    
    public CargaEntidadeParticipante() {
        this.estadoDAO = new EstadoDAOImpl();
        this.endDAO = new TempEndPasaDAOImpl();
        this.enderecoDAO = new EnderecoDAOImpl();
        this.municipioDAO = new MunicipioDAOImpl();
        this.documentoDAO = new DocumentoDAOImpl();
        this.telefoneDAO = new TelefoneDAOImpl();
        this.nivelEscolaridadeDAO = new NivelEscolaridadeDAOImpl();
        this.participanteDAO = new ParticipanteDAOImpl();
    }
    
    private void setUp(TempBenPASA benModelo) {
        this.endModelo = endDAO.get(benModelo.getEmpresa(), benModelo.getMatricula(), benModelo.getCodBeneficiario());
    }
    
    public Long newParticipante(TempBenPASA modelo) {
        this.setUp(modelo);
        this.participante = new Participante();
        this.setAtributos(modelo);

        //ENDERECO
        Long idEnd = newEndereco();
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

        //TELEFONES
        participante.setTelefones(newTelefones());
        
        //CARGA
        participante.setIdUsuario(CargaPasaCommon.USER_CARGA);
        participante.setIndAtivo(CargaPasaCommon.ATIVO);
        participante.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        
        Long idParticipante = participanteDAO.save(participante);
        linkListas(idParticipante);//TELEFONE E DOCUMENTO
        
        return idParticipante;
    }
    
    private Long newEndereco() {
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
        endereco.setCep(endModelo.getCep());//BuscaCEP.getCepasString(endModelo.getCep());
        
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
    
    private List<Long> newTelefones() {
        List<Long> lista = new ArrayList<>();
        Telefone telefone1 = new Telefone();
        Telefone telefone2 = new Telefone();
        Telefone telefone3 = new Telefone();
        
        if (endModelo.getTelefone1().length() > 0) {
            telefone1.setNumeroTelefone(endModelo.getTelefone1());
            telefone1.setIndAtivo(CargaPasaCommon.ATIVO);
            telefone1.setIdUsuario(CargaPasaCommon.USER_CARGA);
            telefone1.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            Long id = telefoneDAO.save(telefone1);
            if (null != id) {
                lista.add(id);
            }
        }
        
        if (endModelo.getTelefone2().length() > 0) {
            telefone2.setNumeroTelefone(endModelo.getTelefone2());
            telefone2.setIndAtivo(CargaPasaCommon.ATIVO);
            telefone2.setIdUsuario(CargaPasaCommon.USER_CARGA);
            telefone2.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            Long id = telefoneDAO.save(telefone2);
            if (null != id) {
                lista.add(id);
            }
        }
        
        if (endModelo.getTelefone3().length() > 0) {
            telefone3.setNumeroTelefone(endModelo.getTelefone3());
            telefone3.setIndAtivo(CargaPasaCommon.ATIVO);
            telefone3.setIdUsuario(CargaPasaCommon.USER_CARGA);
            telefone3.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            Long id = telefoneDAO.save(telefone3);
            if (null != id) {
                lista.add(id);
            }
        }
        
        return lista;
    }
    
    private void setAtributos(TempBenPASA modelo) {
        participante.setCpf(modelo.getCpf());
        participante.setDataFalecimento(DateUtil.toDate(modelo.getDataFalecimento()));
        participante.setDataNascimento(DateUtil.toDate(modelo.getDataNascimento()));
        participante.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        // participante.setEmail(modelo.get);
        participante.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modelo.getIndicadorConclusao()));
        participante.setNome(modelo.getNomeCompleto());
        participante.setNomeMae(modelo.getNomeDaMae());
        participante.setSexo(modelo.getSexo());
        participante.setEstadoCivil(2L);
        participante.setNacionalidade(1L);
    }
    
    private void linkListas(Long idParticipante){
        if(!participante.getTelefones().isEmpty()){
            for(Long idTelefone : participante.getTelefones()){
                telefoneDAO.linkParticipanteTelefone(idParticipante, idTelefone);
            }
        }
        
        if(!participante.getDocumentos().isEmpty()){
            for(Long idDocumento : participante.getDocumentos()){
                documentoDAO.linkParticipanteDocumento(idParticipante, idDocumento);
            }
        }
    }
}
