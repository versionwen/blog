package com.version.aspect;

import com.version.handler.ControllerException;
import lombok.var;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/21 18:07
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.version.web.*.*(..) )")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        Requestlog requestlog=new Requestlog(url,ip,classMethod,args);
        logger.info("Request :{}",requestlog);
        logger.info("----------before-------");
    }
    @After("log()")
    public void doAfter(){
        logger.info("----------After-------");
    }
    @AfterReturning(returning = "res",pointcut = "log()")
    public void doAferRuntime(Object res){
        logger.info("----------AfterRes-------");
        logger.info("Result: {}",res);
    }
    public class Requestlog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public Requestlog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }
    }
}
