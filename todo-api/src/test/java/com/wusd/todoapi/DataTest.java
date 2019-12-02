package com.wusd.todoapi;

import com.wusd.todoapi.dao.gen.ItemMapper;
import com.wusd.todoapi.dao.gen.UnitMapper;
import com.wusd.todoapi.entity.gen.Item;
import com.wusd.todoapi.entity.gen.Unit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class DataTest extends TodoApiApplicationTests {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private UnitMapper unitMapper;

    @Test
    public void addData() {
        for (int i = 0; i < 5; i++) {
            Item item = new Item();
            item.setItemId(UUID.randomUUID().toString());
            item.setItemName("事项名称" + i);
            item.setUnread(0);
            item.setCreateTime(System.currentTimeMillis());
            itemMapper.insertSelective(item);
            for (int j = 0; j < 5; j++) {
                Unit unit = new Unit();
                unit.setUnitId(UUID.randomUUID().toString());
                unit.setItemId(item.getItemId());
                unit.setUnitName(item.getItemName() + "--" + "单项名称" + i);
                unit.setUnitContent(unit.getUnitName() + "--" + "内容");
                unit.setCreateTime(System.currentTimeMillis());
                unitMapper.insertSelective(unit);
            }
        }

    }

}
