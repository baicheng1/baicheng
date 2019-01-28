package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Information implements Serializable {
    private Integer id;
    private String infoName;
    private String infoUrl;
    private String infoContent;
    private String infoType;
    private Date infoCreated;
}
