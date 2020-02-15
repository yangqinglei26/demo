package com.example.controller;

import com.example.config.ApiJsonObject;
import com.example.config.ApiJsonProperty;
import com.example.config.validate.First;
import com.example.config.validate.IGroup;
import com.example.entity.Teacher;
import com.example.entity.User;
import io.swagger.annotations.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.Map;

@RestController
@Api(tags="测试swagger")
@Validated
public class IndexController {

    @PostMapping("/post")
    @ApiOperation(value = "map请求测试",notes = "author:yql")
    @ApiJsonObject(
            name = "temp", value = {
            @ApiJsonProperty(key = "userId", example = "xsy123", description = "用户Id必传", type = "string", required = true),
            @ApiJsonProperty(key = "indexs", example = "1,2", description = "指标编号非必传", type = "string", required = false),
            @ApiJsonProperty(key = "queryDate", example = "2018-12-24", description = "查询日期非必传", type = "string", required = false) }
    )
    public Map<String, String> index( @RequestBody Map<String, String> temp){
        return temp;
    }
    /*
     * @Author yql
     * @Description TODO
     * @Date 2019/11/6 18:28 
     * @param id
     * @param name
     * @return : java.lang.String
     */
    @GetMapping("/get/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "String",example = "123"),
            @ApiImplicitParam(name = "name",value = "用户姓名",required = true,dataType = "string",example = "2019-01-02")
    })
    public Date  index(@PathVariable("id")@NotNull @Length(min = 6, max = 18, message = "用户名长度必须为6-18位") String id, @RequestParam() Date name ){
//        int i =1/0;
        return name;
    }

    @GetMapping("/user")
    public User  user(@Valid User user){
        return user;
    }

    @GetMapping("/user1")
    public User  user1(@Validated({First.class}) User user){
        return user;
    }

    /*
     * @Author yql
     * @Description http://localhost:8080/user2?licensePlate=adf&manufacturer=1
     * @Date 2019/12/25 10:47
     * @param user
     * @return : com.example.entity.User
     */
    @GetMapping("/user2")
    public User  user2(@Validated({IGroup.class}) User user){
        return user;
    }

    @GetMapping("/teacher")
    public Teacher  teacher(@Valid Teacher teacher){
        return teacher;
    }

    /*
     * @Author yql
     * @Description get请求不支持map接收参数
     * @Date 2019/11/6 18:17 
     * @param temp
     * @return : java.util.Map<java.lang.String,java.lang.String>
     */
    @GetMapping("/map")
    public Map<String, String>  user(Map<String, String> temp){
        return temp;
    }

}
