package com.huhu.wordgo.repo.dao;

import com.huhu.wordgo.repo.po.PositionPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PositionDao {

    void insertPosition(PositionPO positionPO);
}
