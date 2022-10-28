package com.example.firstservice;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/first-service/")
@RequiredArgsConstructor
@Slf4j
public class FirstServiceController {

    private final Environment environment;

    @GetMapping("welcome")
    public String welcome() {
        return "Welcome to the First Service.";
    }

    @GetMapping("message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return "Hello World in First Service";
    }

    @GetMapping("check")
    public String check(HttpServletRequest httpServletRequest) {
        log.info("server port={}",httpServletRequest.getServerPort());
        return String.format("Hi there this is a message from first service on port %s",
                environment.getProperty("local.server.port"));
    }

}
