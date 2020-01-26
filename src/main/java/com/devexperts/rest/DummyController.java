package com.devexperts.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class DummyController {

    @RequestMapping("/")
    public String home()
    {
        return "redirect:swagger-ui.html";
    }
}
