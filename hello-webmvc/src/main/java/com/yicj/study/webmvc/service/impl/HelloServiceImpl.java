package com.yicj.study.webmvc.service.impl;

import com.yicj.study.webmvc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author yicj
 * @date 2023年10月16日 11:02
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
