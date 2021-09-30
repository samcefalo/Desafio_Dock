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

}
