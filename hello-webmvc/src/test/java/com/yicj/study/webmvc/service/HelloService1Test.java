package com.yicj.study.webmvc.service;

import com.yicj.study.webmvc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author yicj
 * @date 2023年10月16日 11:04
 */
@Slf4j
@ContextConfiguration(classes = AppConfig.class)
public class HelloService1Test extends AbstractJUnit4SpringContextTests {

    @Autowired
    private HelloService helloService ;

    @Test
    public void hello(){
        String retValue = helloService.hello("张三");
        log.info("{}", retValue);
    }

}
