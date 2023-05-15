package com.tangxy.soccerpro.config;

import com.tangxy.soccerpro.service.Impl.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TokenConFiguration implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除拦截，除了登录，其他都拦截
        registry.addInterceptor(tokenInterceptor)
                .excludePathPatterns("/loginRegister/**","/wenzhan/**","/Hqxw/**","/tianqi/**","/Lts/**","/imserver/**","/Permsg/**","/LearningVideo/**"
                        ,"/Car/**","/register/**","/swagger**","/api/**","/doc**","/favicon.co","/webjars/**")
                .addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
