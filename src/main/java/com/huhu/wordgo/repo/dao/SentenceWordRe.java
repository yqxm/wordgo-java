package com.huhu.wordgo.repo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SentenceWordRe {

    void insertRelation(Integer sentenceId, Integer wordId);
}
