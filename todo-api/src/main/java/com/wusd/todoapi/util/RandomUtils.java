package com.wusd.todoapi.util;

import java.util.UUID;

public class RandomUtils {
    public static String random() {
        return UUID.randomUUID().toString();
    }
}
