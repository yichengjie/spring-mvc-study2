package com.yicj.study.webmvc.service.impl;

import com.yicj.study.webmvc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author yicj
 * @date 2023/10/17 22:50
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello, " + name;
    }
}
