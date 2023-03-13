package com.huhu.wordgo.repo.dao;

import com.huhu.wordgo.repo.po.SentencePO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SentenceDao {

    void insertSentence(SentencePO sentencePO);
}
