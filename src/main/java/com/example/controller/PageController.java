package com.example.controller;

import com.example.entity.ThObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @Description TODO
 * @Author yql
 * @Date 2019/11/9 17:03
 * @Version 1.0
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/get")
    public String index(@RequestParam Date name, Map<String, Object>  model ){
        model.put("date",name);
        model.put("sex","女");
        model.put("phone","123");
        model.put("location","tj");
        model.put("bb","bb");
        model.put("aa","bb");
        return "page";
    }

    @GetMapping("/thymeleaf1")
    public String thymeleaf(ModelMap map) {
        map.put("thText", "th:text 设置文本内容 <b>加粗</b>");
        map.put("thUText", "th:utext 设置文本内容 <b>加粗</b>");
        map.put("thValue", "thValue 设置当前元素的value值");
        map.put("thEach", Arrays.asList("th:each", "遍历列表"));
        map.put("thIf", "msg is not null");
        map.put("thObject", new ThObject(1L, "th:object", "用来偷懒的th属性"));
        return "thymleaf1";
    }
}
