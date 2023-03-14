package com.huhu.wordgo.repo.dao;

import com.huhu.wordgo.repo.po.OriginPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OriginDao {

    OriginPO selectOriginById(Integer id);
}
