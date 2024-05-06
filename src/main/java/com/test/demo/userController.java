package com.test.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class userController {

    @GetMapping("/user")
    @ResponseBody
    public Map<String, Object> getMethodName() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Get Api");
        response.put("data", "Successful");
        return response;
    };

    @PostMapping("/user")
    @ResponseBody
    public Map<String, Object> hello(@RequestBody String requestBody) {
        Map<String, Object> response = new HashMap<>();

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            // Parse the request body into a JSON object
            Map<String, Object> requestBodyMap = objectMapper.readValue(requestBody,
                    new TypeReference<Map<String, Object>>() {
                    });

            System.err.println(requestBody);
            String number1 = (String) requestBodyMap.get("number1");
            String number2 = (String) requestBodyMap.get("number2");

            System.out.println(number1);

            int inunber1 = Integer.parseInt(number1);
            int inunber2 = Integer.parseInt(number2);

            if (inunber1 > inunber2) {
                response.put("message", "success");
                response.put("large Number", inunber1);
            } else {
                response.put("message", "success");
                response.put("large Number", inunber2);
            }

        } catch (Exception e) {
            response.put("message", "error");
            response.put("error", e.getMessage());
        }

        return response;
    }

    @PutMapping("/user")
    @ResponseBody
    public Map<String, Object> putMethodName() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Put Api");
        response.put("data", "Successful");

        return response;
    }

}
