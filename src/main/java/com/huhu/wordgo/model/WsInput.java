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

}
