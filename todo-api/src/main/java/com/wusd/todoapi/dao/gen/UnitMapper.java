package com.wusd.todoapi.dao.gen;

import com.wusd.todoapi.entity.gen.Unit;
import com.wusd.todoapi.entity.gen.UnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnitMapper {
    int countByExample(UnitExample example);

    int deleteByExample(UnitExample example);

    int deleteByPrimaryKey(String unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    List<Unit> selectByExample(UnitExample example);

    Unit selectByPrimaryKey(String unitId);

    int updateByExampleSelective(@Param("record") Unit record, @Param("example") UnitExample example);

    int updateByExample(@Param("record") Unit record, @Param("example") UnitExample example);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}