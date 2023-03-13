package com.huhu.wordgo.repo.dao;

import com.huhu.wordgo.repo.po.WordPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface WordDao {

    void insertWord(WordPO wordPO);

    void updateWord(WordPO wordPO);

    Optional<WordPO> selectById(Integer id);

    Optional<WordPO> selectByAlphas(String alphas);
}
