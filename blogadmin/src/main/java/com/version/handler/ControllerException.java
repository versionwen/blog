package com.version.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/21 16:09
 */
@ControllerAdvice
public class ControllerException {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(HttpServletRequest request,Exception e){
        logger.error("Requst URL : {},Exception : {}",request.getRequestURL(),e);
        ModelAndView mv=new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        return mv;
    }

}
