package com.huhu.wordgo.repo.dao;

import com.huhu.wordgo.repo.po.WordPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WordDao {

    void insertWord(WordPO wordPO);

    void updateWord(WordPO wordPO);

    WordPO selectById(Integer id);
}
