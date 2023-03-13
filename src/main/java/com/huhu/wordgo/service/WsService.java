package com.huhu.wordgo.service;

import com.huhu.wordgo.model.Word;
import com.huhu.wordgo.model.WsInput;
import com.huhu.wordgo.repo.WsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<Word> wordList = wsInput.createWordList();
        for (Word w : wordList) {
            wsRepo.saveWord(w);
        }


    }
}
