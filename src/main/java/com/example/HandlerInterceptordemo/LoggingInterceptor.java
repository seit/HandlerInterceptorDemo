package com.example.HandlerInterceptordemo;

import org.slf4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingInterceptor extends HandlerInterceptorAdapter {

    Logger logger = org.slf4j.LoggerFactory.getLogger(getClass().getPackage().getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestUri = request.getRequestURI();
        String requestMethod= request.getMethod();
        String referer = request.getHeader("Referer");
        HandlerMethod hm = (HandlerMethod) handler;
        String handlerClassName = hm.getMethod().getDeclaringClass().getSimpleName();
        String handlerMethodName = hm.getMethod().getName();

        String logInfo = new StringBuffer()
                .append(requestUri)
                .append(", method ")
                .append(requestMethod)
                .append(", from ")
                .append(referer)
                .append(", handlerClassName")
                .append(handlerClassName)
                .append(", handlerMethodName")
                .append(handlerMethodName).toString();

        logger.info(logInfo);

        return true;
    }
}
