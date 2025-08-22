package com.github.viihcerq.study_apir.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ping")
public class ControllerPing {

    @Value("${api.version}")
    private String value;

    @GetMapping("/version")
    public String ping(){
        return "version" + value;
    }

}
