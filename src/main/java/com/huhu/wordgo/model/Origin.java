package com.huhu.wordgo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Origin {
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
