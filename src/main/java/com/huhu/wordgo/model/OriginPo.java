package com.huhu.wordgo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OriginPo {
    private Integer id;
    private Integer originId;
    private String poIndex;
    private String poName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
