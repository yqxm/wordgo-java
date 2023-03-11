package com.huhu.wordgo.repo.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SentencePO {
    private Integer id;
    private String content;
    private PositionPO po;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
