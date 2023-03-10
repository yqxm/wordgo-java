package com.huhu.wordgo.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class WsInput {

    Integer originId;

    String poIndex;
    String poName;

    String content;

    List<String> wordList;

    public OriginPo createOriginPo() {
        OriginPo op = new OriginPo();
        op.setOriginId(originId);
        op.setPoIndex(poIndex);
        op.setPoName(poName);
        op.setCreateTime(LocalDateTime.now());
        op.setUpdateTime(LocalDateTime.now());
        return op;
    }

    public List<Word> createWordList() {
        List<Word> results = new ArrayList<>();
        for (String s : wordList) {
            Word w = new Word();
            w.setAlphas(s);
            w.setCreateTime(LocalDateTime.now());
            w.setUpdateTime(LocalDateTime.now());
            results.add(w);
        }
        return results;
    }

}
