package com.example.entity;

import com.example.config.validate.Second;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description TODO
 * @Author yql
 * @Date 2019/12/24 17:57
 * @Version 1.0
 */
@Data
public class Info {

    //当字符串非空时，才会验证length
    @NotNull
    @Length(min = 6, max = 18, message = "用户名长度必须为6-18位")
    private String father;
    @NotEmpty(groups={Second.class},message ="姓名不能为空")
    private String mother;
    private String location ;
}
