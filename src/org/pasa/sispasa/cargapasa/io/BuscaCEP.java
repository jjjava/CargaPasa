package org.pasa.sispasa.cargapasa.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.pasa.sispasa.cargapasa.model.Endereco;

/**
 *
 * @author Hudson Schumaker
 */
public class BuscaCEP {

    public Endereco pesquisarEnderecoPorCEP(String cep) throws Exception {
        return retornarEnderecoObject(retornarEnderecoJson(cep));
    }

    public static String getCepasString(String cep) throws Exception {
        return retornarEnderecoObject(retornarEnderecoJson(cep)).getCep();
    }

    private static String retornarEnderecoJson(String cep) throws Exception {
        URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder jsonSb = new StringBuilder();
        br.lines().forEach(l -> jsonSb.append(l.trim()));
        return jsonSb.toString();
    }

    private static Endereco retornarEnderecoObject(String json) throws Exception {
        Map<String, String> mapEnderecoFromJson = new HashMap<>();
        Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);
        while (matcher.find()) {
            String[] group = matcher.group().split(":");
            mapEnderecoFromJson.put(group[0].replaceAll("\"", "").trim(), group[1].replaceAll("\"", "").trim());
        }
        if (!mapEnderecoFromJson.isEmpty()) {
            Endereco endereco = new Endereco();
            endereco.setCep(mapEnderecoFromJson.get("cep"));
            return endereco;
        } else {
            throw new Exception("endereco.cep.invalido");
        }
    }
}
