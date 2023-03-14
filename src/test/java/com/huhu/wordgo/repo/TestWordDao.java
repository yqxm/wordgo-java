package com.huhu.wordgo.repo;

import com.huhu.wordgo.repo.dao.WordDao;
import com.huhu.wordgo.repo.po.WordPO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestWordDao {

    WordDao wordDao;

    @Autowired
    public void setWordDao(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    @Test
    public void testSelectWordById() {
        var opo = wordDao.selectById(1);
        Assert.isTrue(opo.isPresent() && opo.get().getAlphas().equals("excessive"), "Base on the test data, the word with id 1 is excessive.");
    }

    @Test
    public void testSelectWordByAlphas() {
        var opo = wordDao.selectByAlphas("excessive");
        Assert.isTrue(opo.isPresent() && opo.get().getAlphas().equals("excessive"), "Base on the test data, the word with id 1 is excessive.");
    }

    @Test
    public void testSaveWord() {
        WordPO wordPO = new WordPO();
        wordPO.setAlphas("hello");
        wordPO.setCreateTime(LocalDateTime.now());
        wordPO.setUpdateTime(LocalDateTime.now());
        wordDao.insertWord(wordPO);
        Assert.isTrue(wordPO.getId() != null, "id is not null after insertion.");
    }
}
