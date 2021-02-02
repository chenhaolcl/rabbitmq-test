package cn.ch.handler;

import cn.ch.enums.CodeEnum;
import cn.ch.exception.EmptyResutlException;
import cn.ch.exception.RequestParamException;
import cn.ch.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * @Classname GlobalExceptionHandler
 * @Description
 * @create 2021/2/2
 * @Author random
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 查询结果为空时处理
     * @param e
     * @return
     */
    @ExceptionHandler(EmptyResutlException.class)
    public ServerResponse emptyResultExceptionHandler(EmptyResutlException e){
        log.error("查询结果为空：{}",e.getMsg());
        return ServerResponse.error(e.getCode(),e.getMsg());
    }

    /**
     * 请求参数错误时处理
     * @param e
     * @return
     */
    @ExceptionHandler(RequestParamException.class)
    public ServerResponse requestParamExceptionHandler(RequestParamException e){
        log.error("请求参数不合法：{}",e.getMsg());
        return ServerResponse.error(e.getCode(),e.getMsg());
    }

    /**
     * 处理IO异常
     * @param e
     * @return
     */
    @ExceptionHandler(IOException.class)
    public ServerResponse ioExceptionHandler(IOException e){
        log.error("IO异常：{}",e.getMessage());
        return ServerResponse.error("io流异常");
    }

    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ServerResponse exceptionHandler(Exception e){
        log.error("未知异常：{}",e.getMessage());
        return ServerResponse.error(CodeEnum.ERROR.getMsg());
    }
}
