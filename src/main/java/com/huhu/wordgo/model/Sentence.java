package com.huhu.wordgo.model;

import com.huhu.wordgo.repo.po.PositionPO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sentence {
    private Integer id;
    private String content;
    private Position position;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
