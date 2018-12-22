package com.xiafei.newsbackend.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created by qujie on 2018/12/17
 * 向mvc中添加自定义组件
 */
@Configuration
public class WebMvcInterceptor extends WebMvcConfigurerAdapter {

    @Resource
    BaseInterceptor baseInterceptor;

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 无需拦截的url
         */
        String loginExcludePathPatterns[] = {
                "/admin/**",
                "/index"
        };
        registry.addInterceptor(baseInterceptor);
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/*/**").excludePathPatterns(loginExcludePathPatterns);
        super.addInterceptors(registry);
    }

}
