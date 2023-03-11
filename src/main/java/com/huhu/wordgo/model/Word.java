package com.huhu.wordgo.model;

import com.huhu.wordgo.repo.po.WordPO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class Word {
    private Integer id;
    private String alphas;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public WordPO toPO() {
        WordPO po = new WordPO();
        BeanUtils.copyProperties(this, po);
        return po;
    }
}
