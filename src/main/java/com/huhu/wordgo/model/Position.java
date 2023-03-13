package com.huhu.wordgo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Position {
    private Integer id;
    private Origin origin;
    private String poIndex;
    private String poName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
