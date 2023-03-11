package com.huhu.wordgo.repo.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PositionPO {
    private Integer id;
    private Integer originId;
    private String poIndex;
    private String poName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
