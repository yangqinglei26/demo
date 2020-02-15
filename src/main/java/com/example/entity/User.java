package com.example.entity;

import com.example.config.MyConstraint;
import com.example.config.validate.First;
import com.example.config.validate.Second;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @NotNull
    @Size(min = 2, max = 14,groups = {First.class})
    private String manufacturer;

    //当包含自定义注解时，默认不检测其他注解
    @MyConstraint
    private String licensePlate;

    @Range(min = 1, max = 120, message = "年龄必须为1-120岁")
    private int seatCount;
    @NotNull
    @Valid
    private Info info;

    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式错误")
    private String phoneNum;

}
