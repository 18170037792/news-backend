package com.xiafei.newsbackend.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    @Value("${web.upload-path}")
    String uploadPath;

    @Resource
    BaseInterceptor baseInterceptor;

//    @Bean
//    LoginInterceptor loginInterceptor(){
//        return new LoginInterceptor();
//    }

    /**
     * 添加拦截器
     * @param registry
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 无需拦截的url
         */
        String loginExcludePathPatterns[] = {
                "/admin/user/login",
                "/index",
                "/contact",
                "/about",
                "/single/**",
                "/ueditor"
        };
        registry.addInterceptor(baseInterceptor);
        //registry.addInterceptor(loginInterceptor()).addPathPatterns("/*/**").excludePathPatterns(loginExcludePathPatterns);
        super.addInterceptors(registry);
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     * addResourceHandler 配置需要处理的资源映射
     * addResourceLocations
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/"+uploadPath+"/**").addResourceLocations("file:"+ uploadPath);
//        super.addResourceHandlers(registry);
//    }

}
