package com.huhu.wordgo.repo;

import com.huhu.wordgo.model.Sentence;
import com.huhu.wordgo.model.Word;
import com.huhu.wordgo.repo.dao.SentenceDao;
import com.huhu.wordgo.repo.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WsRepo {

    WordDao wordDao;
    SentenceDao sentenceDao;

    @Autowired
    public void setWordDao(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    public void saveWord(Word word) {
        var opo = wordDao.selectByAlphas(word.getAlphas());
        if (opo.isEmpty()) {
            wordDao.insertWord(word.toPO());
        }
    }

    public void saveSentence(Sentence sentence) {

    }
}
