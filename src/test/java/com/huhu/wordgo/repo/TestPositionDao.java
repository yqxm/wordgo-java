package com.huhu.wordgo.repo;

import com.huhu.wordgo.repo.dao.PositionDao;
import com.huhu.wordgo.repo.po.PositionPO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestPositionDao {

    PositionDao positionDao;

    @Autowired
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Test
    public void testInsertPosition() {
        PositionPO po = new PositionPO();
        po.setOriginId(1);
        po.setPoName("Introduction");
        po.setPoIndex("1");
        po.setCreateTime(LocalDateTime.now());
        po.setUpdateTime(LocalDateTime.now());
        positionDao.insertPosition(po);
        Assert.isTrue(po.getId() != null, "id is not null after insertion.");
    }
}
