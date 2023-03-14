package com.huhu.wordgo.repo;

import com.huhu.wordgo.repo.dao.SentenceDao;
import com.huhu.wordgo.repo.po.SentencePO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Commit;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestSentenceDao {

    SentenceDao sentenceDao;

    @Autowired
    public void setSentenceDao(SentenceDao sentenceDao) {
        this.sentenceDao = sentenceDao;
    }

    @Test
    public void testInsetSentence() {
        SentencePO po = new SentencePO();
        po.setContent("test1");
        po.setPositionId(1);
        po.setCreateTime(LocalDateTime.now());
        po.setUpdateTime(LocalDateTime.now());
        sentenceDao.insertSentence(po);
        Assert.isTrue(po.getId() != null, "id is not null after insertion.");
    }
}
