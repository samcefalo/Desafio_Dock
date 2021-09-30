package me.samcefalo.desafio.domain.dto;

import lombok.Data;
import me.samcefalo.desafio.domain.Entidade;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/*
 * Camada de Validação
 * Data transfer object
 */

@Data
public class EntidadeDTO implements Serializable {

    //TODO resolver required para integers
    private int logic;
    @NotBlank
    private String serial;
    @NotBlank
    private String model;
    @Min(0)
    private int sam;
    private String ptid;
    private int plat;
    @NotBlank
    private String version;
    private int mxr;
    private int mxf;
    private String verfm;

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
        this.verfm = entidade.getVerfm();
    }

}
