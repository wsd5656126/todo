package com.wusd.todoapi.controller;

import com.wusd.todoapi.dao.gen.ItemMapper;
import com.wusd.todoapi.entity.gen.Item;
import com.wusd.todoapi.entity.gen.ItemExample;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item")
@Api
public class ItemController {
    @Autowired
    private ItemMapper itemMapper;

    @GetMapping("/list")
    public List<Item> list() {
        ItemExample itemExample = new ItemExample();
        List<Item> items = itemMapper.selectByExample(itemExample);
        return items;
    }

    @GetMapping("/detail")
    public Item detail(@RequestParam("itemId") String itemId) {
        Item item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }

    @GetMapping("/add")
    public void add() {
        Item item = new Item();
        item.setItemId(UUID.randomUUID().toString());
        item.setItemName("newList");
        item.setCreateTime(System.currentTimeMillis());
        item.setUnitNum(0);
        itemMapper.insertSelective(item);
    }

    @PostMapping("/modify")
    public void modify(
            @RequestParam("itemId") String itemId,
            @RequestParam(value = "itemName", required = false) String itemName,
            @RequestParam(value = "state", required = false) Integer state
    ) {
        if (state != null && state == 0) {
            itemMapper.deleteByPrimaryKey(itemId);
        } else {
            Item item = new Item();
            item.setItemId(itemId);
            item.setItemName(itemName);
            itemMapper.updateByPrimaryKeySelective(item);
        }
    }
}
