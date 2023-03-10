package com.huhu.wordgo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Word {
    private Integer id;
    private String alphas;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
