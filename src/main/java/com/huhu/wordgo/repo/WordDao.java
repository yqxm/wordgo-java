package com.huhu.wordgo.repo;

import com.huhu.wordgo.model.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WordDao {

    @Select("SELECT id, alphas, create_time as createTime , update_time as updateTime FROM word")
    List<Word> getAllWords();
}
