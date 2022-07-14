package com.example.demo.exception.handler;


import com.example.demo.common.ResultBean;
import com.example.demo.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;

@ControllerAdvice
@Slf4j
public class GlobleExceptionHandler {

    @ExceptionHandler(value = {MyException.class})
    @ResponseBody
    public ResultBean errorHandler(MyException e){
        log.info("业务异常发生:{}",e.getMessage());
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return ResultBean.errorException(e.getMessage());
    }

}
