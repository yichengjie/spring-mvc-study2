package com.yicj.study.hello.web.servlet;

import com.yicj.study.hello.exception.BusinessException;
import com.yicj.study.hello.web.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * BusinessExceptionHandler
 * </p>
 *
 * @author yicj
 * @since 2023年11月20日 11:39
 */
@Slf4j
@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public RestResponse<String> businessExceptionHandler(BusinessException exception){
        log.info("Business exception ...", exception);
        return RestResponse.fail(exception.getMessage()) ;
    }
}
