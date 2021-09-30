package me.samcefalo.desafio.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
public class EntidadeDTO implements Serializable {

    @NotEmpty
    private int logic;
    @NotEmpty
    private String serial;
    @NotEmpty
    private String model;
    @Length(min = 0)
    private int sam;
    private String ptid;
    private int plat;
    @NotEmpty
    private String version;
    private int mxr;
    private int mxf;
    private String verfm;

}
