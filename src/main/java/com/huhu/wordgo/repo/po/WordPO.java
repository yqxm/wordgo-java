package com.huhu.wordgo.repo.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WordPO {
    private Integer id;
    private String alphas;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
