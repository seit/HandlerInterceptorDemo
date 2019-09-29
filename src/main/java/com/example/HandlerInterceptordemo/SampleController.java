package com.example.HandlerInterceptordemo;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    Logger logger = org.slf4j.LoggerFactory.getLogger(getClass().getPackage().getName());


    @GetMapping("/")       // URLのパスの指定
    private String top() { // リクエストを受け付けるメソッド

        logger.info("これはControllerのログです。");

        return "/index";
    }
}