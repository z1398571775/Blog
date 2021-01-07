package com.yjdxs.blog.cofig;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//Window环境下
        registry.addResourceHandler("/image/**").addResourceLocations("file:E:\\java\\WorkHome\\Blog\\src\\main\\webapp\\image\\");
    }
}
