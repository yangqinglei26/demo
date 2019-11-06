package com.example.filter;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler  {

    @ExceptionHandler(Exception.class)
    public ModelAndView myerroe(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("myerror");
        mv.addObject("error",e.getMessage());
        return mv;
    }

    @ExceptionHandler(RuntimeException.class)
    public String myerroe1(Exception e){
        return "myerror";
    }

    @InitBinder
    public void initWebBinder(WebDataBinder binder){
        //对日期的统一处理
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
        //添加对数据的校验
        //binder.setValidator();
    }
}
