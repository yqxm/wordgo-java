package com.huhu.wordgo.service;

import com.huhu.wordgo.model.Position;
import com.huhu.wordgo.model.Sentence;
import com.huhu.wordgo.model.Word;
import com.huhu.wordgo.model.WsInput;
import com.huhu.wordgo.repo.WsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class WsService {

    WsRepo wsRepo;

    @Autowired
    public void setWsRepo(WsRepo wsRepo) {
        this.wsRepo = wsRepo;
    }

    @Transactional
    public void processWsInput(WsInput wsInput) {
        Sentence sentence = wsRepo.saveSentence(wsInput.createSentence());

        for (Word w : wsInput.createWordList()) {
            w = wsRepo.saveWord(w);
            wsRepo.bindSentenceAndWord(sentence, w);
        }
    }
}
