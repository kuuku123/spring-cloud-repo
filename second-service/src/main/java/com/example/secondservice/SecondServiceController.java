package com.example.secondservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/second-service/")
@RequiredArgsConstructor
@Slf4j
public class SecondServiceController {

    private final Environment environment;

    @GetMapping("welcome")
    public String welcome() {
        return "Welcome to the Second Service.";
    }
    @GetMapping("message")
    public String message(@RequestHeader("second-request") String header) {
        log.info(header);
        return "Hello World in Second Service";
    }
    @GetMapping("check")
    public String check(HttpServletRequest httpServletRequest) {
        log.info("server port={}",httpServletRequest.getServerPort());
        return String.format("Hi there this is a message from second service on port %s",
                environment.getProperty("local.server.port"));
    }


}
