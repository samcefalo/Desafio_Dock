package me.samcefalo.desafio.resources.utils;

import me.samcefalo.desafio.domain.Entidade;

public class ObjectParser {

    public static Entidade parseObject(String string, Class<?> objClass, String separator) {
        String[] vetor = string.split(separator);
        Entidade entidade = new Entidade();
        for (String v : vetor) {
            //TODO instanciar Entidade
        }
        return entidade;
    }

}
