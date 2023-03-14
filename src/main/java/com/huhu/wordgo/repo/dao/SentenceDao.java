package com.huhu.wordgo.repo.dao;

import com.huhu.wordgo.repo.po.SentencePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface SentenceDao {

    void insertSentence(SentencePO sentencePO);

    Optional<SentencePO> selectSentenceByContentAndPositionId(SentencePO sentencePO);
}
