package com.example.filter;

import com.example.config.DateEditor;
import com.example.config.TeacherValidator;
import com.example.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler  {

    @ExceptionHandler(Exception.class)
    public ModelAndView myerroe(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("myerror");
        if(e instanceof BindingResult){
           /* for (ObjectError objectError : ((BindingResult)e).getAllErrors()) {
                FieldError fieldError = (FieldError) objectError;
                mv.addObject("error", "字段："+((FieldError) objectError).getField()+objectError.getDefaultMessage());
            }*/
            mv.addObject("errors", ((BindingResult)e).getAllErrors());
        }else if ( e instanceof ConstraintViolationException){
            mv.addObject("errors1", ((ConstraintViolationException) e).getConstraintViolations());
        }else{
            log.error("错误信息",e);
            mv.addObject("error",e.getMessage());
        }

        return mv;
    }


    /*
     * @Author yql
     * @Description 处理参数
     * @Date 2019/11/6 18:40
     * @param binder
     * @return : void
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder){
        //对日期的统一处理
//        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
        binder.registerCustomEditor(Date.class,new DateEditor());
        //添加对数据的校验
        if(binder.getTarget().getClass().equals(Teacher.class)){
            binder.addValidators(new TeacherValidator());
        }
        
    }

    @ModelAttribute
    public void regModeelAttribute(Model model){
        /*把键值属性放到请求模型中*/
        model.addAttribute("age", "20");
    }

}
