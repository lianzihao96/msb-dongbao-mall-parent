package com.msb.dongbao.portal.web.advice;

import com.msb.dongbao.common.base.TokenException;
import com.msb.dongbao.common.base.result.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClobalExceptionHandle {

    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper customException(){
        return ResultWrapper.builder().code(301).msg("统一异常").build();
    }

    //自定义token异常处理
    @ExceptionHandler(TokenException.class)
    public ResultWrapper tokenException(Exception e){
        return ResultWrapper.getFailBuilder().code(501).msg(e.getMessage()).build();
    }
}

