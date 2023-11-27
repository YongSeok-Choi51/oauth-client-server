package com.example.oauth.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/test")
public class TestController {

    @GetMapping("/hi")
    public String sayHi() {
        return "Protected resources is Serving....";
    }

}
