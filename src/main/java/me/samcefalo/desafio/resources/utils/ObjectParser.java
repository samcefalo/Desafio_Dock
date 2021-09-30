package me.samcefalo.desafio.resources.utils;

import me.samcefalo.desafio.domain.Entidade;

public class ObjectParser {

    public static Entidade parseFromString(String string, String separator) {
        String[] vetor = string.split(separator);
        //Entidade
        Entidade entidade = new Entidade();
        entidade.setLogic(Integer.parseInt(vetor[0]));
        entidade.setSerial(vetor[1]);
        entidade.setModel(vetor[2]);
        entidade.setSam(Integer.parseInt(vetor[3]));
        entidade.setPtid(vetor[4]);
        entidade.setPlat(Integer.parseInt(vetor[5]));
        entidade.setVersion(vetor[6]);
        entidade.setMxr(Integer.parseInt(vetor[7]));
        entidade.setMxf(Integer.parseInt(vetor[8]));
        entidade.setVerfm(vetor[9]);
        return entidade;
    }

}
