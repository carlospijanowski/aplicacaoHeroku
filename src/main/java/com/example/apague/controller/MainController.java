package com.example.apague.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class MainController {
    @GetMapping("/teste")
    public String teste() {
        return "funfando o GEEEEEEEEEEEET !!!!!!!!!!";
    }


}
