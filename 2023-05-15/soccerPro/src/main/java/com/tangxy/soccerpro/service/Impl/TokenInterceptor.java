package com.tangxy.soccerpro.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tangxy.soccerpro.entity.Result;
import com.tangxy.soccerpro.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        System.out.println(request.getRequestURL());
        if(token == null) {
            Result result = Result.build(404, "请先登录");
            // 没有传 token; 提示请先登录
            doResponse(response, result);
        } else {
            try {
                JwtUtil.verify(token);
                return true; // 放行; 去访问接口吧
            } catch (Exception e) {
                Result result = Result.build(404, "请先登录");
                doResponse(response, result);
            }
        }
        return false;
    }

    private void doResponse(HttpServletResponse response, Result result) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(result);
        out.print(s);
        out.flush();
        out.close();
    }
}
