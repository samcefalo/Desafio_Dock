package me.samcefalo.desafio.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Entidade implements Serializable {

    /*
     * TODO criar DTO com validações
     * "required": ["logic", "serial", "model", "version"]
     */

    @Id
    private int logic;
    private String serial;
    private String model;
    // Validação min = 0 -> NotEmpty
    private int sam;
    private String ptid;
    private int plat;
    private String version;
    private int mxr;
    private int mxf;
    private String verfm;

}
