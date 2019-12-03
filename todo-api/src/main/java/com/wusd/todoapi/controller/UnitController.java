package com.wusd.todoapi.controller;

import com.wusd.todoapi.dao.gen.UnitMapper;
import com.wusd.todoapi.entity.gen.Unit;
import com.wusd.todoapi.entity.gen.UnitExample;
import com.wusd.todoapi.util.RandomUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
@Api
public class UnitController {
    @Autowired
    private UnitMapper unitMapper;

    @GetMapping("/list")
    public List<Unit> list(@RequestParam("itemId") String itemId) {
        UnitExample unitExample = new UnitExample();
        unitExample.createCriteria()
                .andItemIdEqualTo(itemId);
        List<Unit> units = unitMapper.selectByExample(unitExample);
        return units;
    }

    @GetMapping("/modify")
    public void modify(
            @RequestParam(value = "unitId", required = false) String unitId,
            @RequestParam(value = "itemId", required = false) String itemId,
            @RequestParam(value = "unitName", required = false) String unitName,
            @RequestParam("status") Integer status
    ) {
        Unit unit = new Unit();
        unit.setUnitId(RandomUtils.random());
        unit.setItemId(itemId);
        unit.setUnitName(unitName);
        unit.setStatus(status);
        unit.setCreateTime(System.currentTimeMillis());
        unitMapper.insertSelective(unit);
        if (status != null && status == 0) {
            unitMapper.deleteByPrimaryKey(unitId);
        }
    }

}
