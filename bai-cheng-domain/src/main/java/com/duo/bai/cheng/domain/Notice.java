package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notice implements Serializable {
    private Integer id;
    private Integer jiJinId;
    private String noticeName;
    private String noticeUrl;
    private String noticeContent;
    private String noticeType;
    private Date noticeCreated;
}
