package com.yicj.study.webmvc.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author yicj
 * @date 2023/10/15 11:39
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.yicj.study.webmvc.controller")
public class WebConfig {

}
