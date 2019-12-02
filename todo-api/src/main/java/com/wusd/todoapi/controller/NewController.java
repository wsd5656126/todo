package com.wusd.todoapi.controller;

import com.wusd.todoapi.entity.New;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Api
@RestController
@RequestMapping("/new")
public class NewController {
    @GetMapping("/list")
    public List<New> list() {
        List<New> news = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            New n= new New();
            n.setId(i);
            n.setContent("内容" + i);
            n.setImgUrl("");
            news.add(n);
        }
        return news;
    }
}
