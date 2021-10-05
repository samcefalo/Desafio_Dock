package me.samcefalo.desafio.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Entidade implements Serializable {

    @Id
    @Column(name = "logic")
    private int logic;
    @Column(name = "serial", length = 32)
    private String serial;
    @Column(name = "model", length = 32)
    private String model;
    @Column(name = "sam")
    private int sam;
    @Column(name = "ptid", length = 32)
    private String ptid;
    @Column(name = "plat")
    private int plat;
    @Column(name = "version", length = 32)
    private String version;
    @Column(name = "mxr")
    private int mxr;
    @Column(name = "mxf")
    private int mxf;
    @Column(name = "verfm", length = 32)
    @JsonProperty("VERFM")
    private String VERFM;

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
        this.VERFM = verfm;
    }
}
