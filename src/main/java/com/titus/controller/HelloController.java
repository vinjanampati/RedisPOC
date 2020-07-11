package com.titus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vinj-venkat on 7/10/2020.
 */

@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/")
    // Define the Hello World controller.
    public String hello() {

        ValueOperations<String, String> ops = this.template.opsForValue();

        // Add a Hello World string to your cache.
        String key = "greeting";
        if (!this.template.hasKey(key)) {
            ops.set(key, "Hello World!");
        }

        // Return the string from your cache.
        return ops.get(key);
    }
}
