package com.example.config;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("+++++++++++++myConstraint init");
    }
 
    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isEmpty(o)){
            return false;
        }
        if (!o.equals(o.toUpperCase())){
            System.out.println("输入信息必须是大写");
            return false;
        }
        return true;
    }
}