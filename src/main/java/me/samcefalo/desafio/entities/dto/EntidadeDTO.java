package me.samcefalo.desafio.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.samcefalo.desafio.entities.Entidade;

import java.io.Serializable;

/*
 * Camada de Validação
 * Data transfer object
 */

@Data
public class EntidadeDTO implements Serializable {

    private int logic;
    private String serial;
    private String model;
    private int sam;
    private String ptid;
    private int plat;
    private String version;
    private int mxr;
    private int mxf;
    @JsonProperty("VERFM")
    private String VERFM;

    public EntidadeDTO() {

    }

    public EntidadeDTO(Entidade entidade) {
        this.logic = entidade.getLogic();
        this.serial = entidade.getSerial();
        this.model = entidade.getModel();
        this.sam = entidade.getSam();
        this.ptid = entidade.getPtid();
        this.plat = entidade.getPlat();
        this.version = entidade.getVersion();
        this.mxr = entidade.getMxr();
        this.mxf = entidade.getMxf();
        this.VERFM = entidade.getVERFM();
    }

}
