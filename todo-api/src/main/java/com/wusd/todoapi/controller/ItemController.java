package com.wusd.todoapi.controller;

import com.wusd.todoapi.dao.gen.ItemMapper;
import com.wusd.todoapi.entity.gen.Item;
import com.wusd.todoapi.entity.gen.ItemExample;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/list2")
    public List<Item> list2() {
        ItemExample itemExample = new ItemExample();
        List<Item> items = itemMapper.selectByExample(itemExample);
        return items;
    }

}
