package com.example.config;

import com.example.entity.Teacher;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;  
import org.springframework.validation.Validator;  
   
public class TeacherValidator implements Validator {
   
    public boolean supports(Class<?> clazz) {  
       // TODO Auto-generated method stub  
       return Teacher.class.equals(clazz);
    }  
   
    public void validate(Object obj, Errors errors) {  
       // TODO Auto-generated method stub
       ValidationUtils.rejectIfEmpty(errors, "username", null, "用戶名不能为空");
        Teacher user = (Teacher) obj;
       if (null == user.getPassword() || "".equals(user.getPassword()))  
           errors.rejectValue("password", null, "密码不能为空");
    }  
   
}