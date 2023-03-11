package com.huhu.wordgo.repo.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OriginPO {
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
