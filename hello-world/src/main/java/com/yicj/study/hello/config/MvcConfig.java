package com.yicj.study.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * <p>
 * MvcConfig
 * </p>
 *
 * @author yicj
 * @since 2023年11月20日 11:08
 */
@Configuration
public class MvcConfig {
    @Bean("jsonView")
    public MappingJackson2JsonView jsonView(){
        return new MappingJackson2JsonView() ;
    }
}
