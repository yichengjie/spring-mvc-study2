package com.yicj.study.hello;

import com.yicj.study.hello.exception.BusinessException;
import com.yicj.study.hello.web.vo.RestResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * HelloWorldApplication
 * </p>
 *
 * @author yicj
 * @since 2023年11月20日 10:59
 */
@RestController
@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {

        SpringApplication.run(HelloWorldApplication.class, args) ;
    }

    @GetMapping("/index.json")
    public RestResponse<String> index(){

        return RestResponse.success("hello world") ;
    }

    @GetMapping("/hello.json")
    public RestResponse<String> hello(){
        throw new BusinessException("自定义异常") ;
    }

}
