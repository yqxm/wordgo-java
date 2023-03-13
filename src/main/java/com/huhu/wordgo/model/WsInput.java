package com.huhu.wordgo.model;

import com.huhu.wordgo.repo.po.OriginPO;
import com.huhu.wordgo.repo.po.PositionPO;
import com.huhu.wordgo.repo.po.WordPO;
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

    public List<Word> createWordList() {
        List<Word> l = new ArrayList<>();
        for (String s : wordList) {
            Word w = new Word();
            w.setAlphas(s);
            w.setCreateTime(LocalDateTime.now());
            w.setUpdateTime(LocalDateTime.now());
            l.add(w);
        }
        return l;
    }

    public Position createPosition(Origin origin) {
        Position position = new Position();
        position.setOrigin(origin);
        position.setPoIndex(poIndex);
        position.setPoName(poName);
        position.setCreateTime(LocalDateTime.now());
        position.setUpdateTime(LocalDateTime.now());
        return position;
    }

    public Sentence createSentence(Position position) {
        Sentence sentence = new Sentence();
        sentence.setPosition(position);
        sentence.setContent(content);
        sentence.setCreateTime(LocalDateTime.now());
        sentence.setUpdateTime(LocalDateTime.now());
        return sentence;
    }


}
