package org.pasa.sispasa.cargapasa.util;

import org.pasa.sispasa.cargapasa.enumeration.EnumSexo;


/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class StringUtil {

    

    public static EnumSexo parseSexo(String s) {
        if (s.equalsIgnoreCase("M")) {
            return EnumSexo.MASCULINO;
        } else {
            return EnumSexo.FEMININO;
        }
    }

    public static Integer parserIndicadorConclusao(String s) {
        if (s.equalsIgnoreCase("C")) {
            return CargaPasaCommon.VERDADEIRO;
        } else {
            return CargaPasaCommon.FALSO;
        }
    }

    public static String removeCharsEspeciais(String value) {
        return value.replaceAll("[ãâàáä]", "a")
                .replaceAll("[êèéë]", "e")
                .replaceAll("[îìíï]", "i")
                .replaceAll("[õôòóö]", "o")
                .replaceAll("[ûúùü]", "u")
                .replaceAll("[ÃÂÀÁÄ]", "A")
                .replaceAll("[ÊÈÉË]", "E")
                .replaceAll("[ÎÌÍÏ]", "I")
                .replaceAll("[ÕÔÒÓÖ]", "O")
                .replaceAll("[ÛÙÚÜ]", "U")
                .replace('ç', 'c')
                .replace('Ç', 'C')
                .replace('ñ', 'n').replace('Ñ', 'N');
    }

    public static String truncTelefone(String tel) {
        if (tel.length() > CargaPasaCommon.TAM_TELEFONE) {
            return tel.substring(0, CargaPasaCommon.TAM_TELEFONE);
        }
        return tel;
    }


}
