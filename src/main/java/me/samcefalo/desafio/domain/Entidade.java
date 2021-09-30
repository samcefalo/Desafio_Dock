package me.samcefalo.desafio.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Entidade implements Serializable {

    @Id
    private int logic;
    private String serial;
    private String model;
    private int sam;
    private String ptid;
    private int plat;
    private String version;
    private int mxr;
    private int mxf;
    private String verfm;

    public Entidade() {

    }

    public Entidade(int logic, String serial, String model, int sam, String ptid, int plat, String version, int mxr, int mxf, String verfm) {
        this.logic = logic;
        this.serial = serial;
        this.model = model;
        this.sam = sam;
        this.ptid = ptid;
        this.plat = plat;
        this.version = version;
        this.mxr = mxr;
        this.mxf = mxf;
        this.verfm = verfm;
    }
}
