package com.example.controller;

import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class IndexController {

    @PostMapping("/post")
    public Map<String, String> index(@RequestBody Map<String, String> temp){
        return temp;
    }
    @GetMapping("/get/{id}")
    public String  index(@PathVariable("id") String id,@RequestParam(name = "test",required=false) String name ){
        int i =1/0;
        return id+":"+name;
    }

    @GetMapping("/user")
    public User  user(User user){
        return user;
    }

    @GetMapping("/map")
    public Map<String, String>  user(Map<String, String> param){
        return param;
    }

}
