package org.pasa.sispasa.cargapasa.map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hudson Schumaker
 */
public class MapaCamposBen {

    private final Map<String, PosicaoCampo> mapa;

    public MapaCamposBen() {
        mapa = new HashMap<>();
        mapa.put(MapaCampos.EMPRESA, new PosicaoCampo(1, 3));
        mapa.put(MapaCampos.MATRICULA, new PosicaoCampo(3, 9));
        mapa.put(MapaCampos.COD_BENEFICIARIO, new PosicaoCampo(9, 11));
        mapa.put(MapaCampos.DIREITO_AMS_CREDENCIAMENTO, new PosicaoCampo(11, 12));
        mapa.put(MapaCampos.DATA_VALIDADE_CREDENCIADO, new PosicaoCampo(12, 22));
        mapa.put(MapaCampos.DIREITO_AMS_REEMBOLSO, new PosicaoCampo(22, 23));
        mapa.put(MapaCampos.DATA_VALIDADE_REEMBOLSO, new PosicaoCampo(23, 33));
        mapa.put(MapaCampos.DATA_DE_ATUALIZACAO, new PosicaoCampo(33, 43));
        mapa.put(MapaCampos.NOME_BENEFICIARIO_ABREVIADO, new PosicaoCampo(43, 66));
        mapa.put(MapaCampos.CODIGO_CR, new PosicaoCampo(67, 74));
        mapa.put(MapaCampos.ORGAO_PESSOAL, new PosicaoCampo(75, 76));
        mapa.put(MapaCampos.VINCULO, new PosicaoCampo(76, 77));
        mapa.put(MapaCampos.PLANO, new PosicaoCampo(77, 78));
        mapa.put(MapaCampos.FAIXA_NIVEL, new PosicaoCampo(78, 79));
        mapa.put(MapaCampos.DATA_NASCIMENTO, new PosicaoCampo(80, 90));
        mapa.put(MapaCampos.DIREITO_ABATER_IR, new PosicaoCampo(90, 91));
        mapa.put(MapaCampos.NUCLEO_DA_AMS, new PosicaoCampo(91, 92));
        mapa.put(MapaCampos.AGENCIA_BANCARIA, new PosicaoCampo(93, 97));
        mapa.put(MapaCampos.BANCO, new PosicaoCampo(98, 101));
        mapa.put(MapaCampos.CONTA_CORRENTE, new PosicaoCampo(101, 111));
        mapa.put(MapaCampos.DATA_ADMISSAO, new PosicaoCampo(112, 122));
        mapa.put(MapaCampos.GRAU_PARENTESCO, new PosicaoCampo(122, 123));
        mapa.put(MapaCampos.FINACEIRA, new PosicaoCampo(123, 124));
        mapa.put(MapaCampos.CONTRATO_TRABALHO, new PosicaoCampo(124, 125));
        mapa.put(MapaCampos.SEXO, new PosicaoCampo(125, 126));
        mapa.put(MapaCampos.EMPRESA_ATUALIZADOR, new PosicaoCampo(126, 128));
        mapa.put(MapaCampos.MATRICULA_ATUALIZADOR, new PosicaoCampo(128, 133));
        mapa.put(MapaCampos.TIPO_BENEFICIARIO, new PosicaoCampo(134, 135));
        mapa.put(MapaCampos.CODIGO_DIREITO_PASA, new PosicaoCampo(135, 136));
       
         mapa.put(MapaCampos.INDICAR_CONCLUSAO, new PosicaoCampo(136, 137));
        mapa.put(MapaCampos.GRAU_ESCOLARIDADE, new PosicaoCampo(137, 138));
       
        mapa.put(MapaCampos.DATA_FALECIMENTO, new PosicaoCampo(138, 148));
        mapa.put(MapaCampos.MATRICULA_PASA, new PosicaoCampo(148, 154));
        mapa.put(MapaCampos.NOME_DA_MAE, new PosicaoCampo(154, 223));
        mapa.put(MapaCampos.PIS, new PosicaoCampo(224, 234));
        mapa.put(MapaCampos.CPF, new PosicaoCampo(235, 246));
        mapa.put(MapaCampos.EMPRESA_ORIGEM, new PosicaoCampo(246, 248));
        mapa.put(MapaCampos.MATRICULA_ORIGEM, new PosicaoCampo(248, 254));
        mapa.put(MapaCampos.EMPRESA_PEOPLE, new PosicaoCampo(254, 257));
        mapa.put(MapaCampos.MATRICULA_PEOPLE, new PosicaoCampo(257, 264));
        mapa.put(MapaCampos.UNIDADE_DE_CONTROLE, new PosicaoCampo(264, 266));
        mapa.put(MapaCampos.CENTRO_DE_CUSTO, new PosicaoCampo(267, 278));
        mapa.put(MapaCampos.MATRICULA_PARTICIPANTE, new PosicaoCampo(279, 284));
        mapa.put(MapaCampos.MATRICULA_REPRESENTANTE_LEGAL, new PosicaoCampo(285, 290));
        mapa.put(MapaCampos.CATEGORIA_PASA, new PosicaoCampo(291, 293));
        mapa.put(MapaCampos.DATA_ADESAO, new PosicaoCampo(293, 303));
        mapa.put(MapaCampos.DATA_INICIO_CARENCIA, new PosicaoCampo(303, 313));
        mapa.put(MapaCampos.DATA_FIM_CARENCIA, new PosicaoCampo(313, 322));
        mapa.put(MapaCampos.NOME_BENEFICIARIO, new PosicaoCampo(323, 372));
        mapa.put(MapaCampos.DIAS_DE_CARENCIA, new PosicaoCampo(373, 376));
        mapa.put(MapaCampos.CODIGO_NACIONAL_SAUDE, new PosicaoCampo(376, 390));
        mapa.put(MapaCampos.DECLARACAO_NASCIDO_VIVO, new PosicaoCampo(391, 401));
    }

    public Map<String, PosicaoCampo> getMapa() {
        return mapa;
    }
}
