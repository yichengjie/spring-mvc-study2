package com.yicj.study.hello.web.servlet;

import com.yicj.study.hello.exception.BusinessException;
import com.yicj.study.hello.exception.ParamException;
import com.yicj.study.hello.web.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * BusinessHandlerExceptionResolver
 * </p>
 *
 * @author yicj
 * @since 2023年11月20日 11:07
 */
@Slf4j
@Component
public class BusinessHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {

    private int order = 0;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "System error";
        // 这里我们要求项目中所有请求json数据，都使用.json结尾
        if (url.endsWith(".json")) {
            if (ex instanceof BusinessException || ex instanceof ParamException) {
                RestResponse<String> result = RestResponse.fail(ex.getMessage());
                mv = new ModelAndView("jsonView", result.toMap());
            } else {
                log.error("unknown json exception, url:" + url, ex);
                RestResponse<String> result = RestResponse.fail(defaultMsg);
                mv = new ModelAndView("jsonView", result.toMap());
            }
        } else if (url.endsWith(".page")){ // 这里我们要求项目中所有请求page页面，都使用.page结尾
            log.error("unknown page exception, url:" + url, ex);
            RestResponse<String> result = RestResponse.fail(defaultMsg);
            mv = new ModelAndView("exception", result.toMap());
        } else {
            log.error("unknow exception, url:" + url, ex);
            RestResponse<String> result = RestResponse.fail(defaultMsg);
            mv = new ModelAndView("jsonView", result.toMap());
        }
        return mv;
    }

    @Override
    public int getOrder() {
        return order -1;
    }
}
