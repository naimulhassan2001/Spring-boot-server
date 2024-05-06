package com.test.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RestController
public class helloController {

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");
        response.put("data", "sdajn fvm,ngv");
        return response;
    }
}
