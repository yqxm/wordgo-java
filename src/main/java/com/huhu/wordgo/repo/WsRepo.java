package com.huhu.wordgo.repo;

import com.huhu.wordgo.model.Word;
import com.huhu.wordgo.repo.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WsRepo {

    WordDao wordDao;

    @Autowired
    public void setWordDao(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    public void saveWord(Word word) {
        if (word.getId() == null) {
            wordDao.insertWord(word.toPO());
        } else {
            wordDao.updateWord(word.toPO());
        }
    }
}
