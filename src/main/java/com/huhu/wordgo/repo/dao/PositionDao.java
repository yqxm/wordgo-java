package com.huhu.wordgo.repo.dao;

import com.huhu.wordgo.repo.po.PositionPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PositionDao {

    Optional<PositionPO> selectPositionByOriginIdAndPoIndexAndPoName(PositionPO positionPO);

    Optional<PositionPO> selectPositionById(Integer id);

    void insertPosition(PositionPO positionPO);
}
