package com.example.apague.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @RequestMapping("/")
    public String pagina1(){
        return "pagina sem layout no main";
    }

    @RequestMapping("/teste/{parametro}")
    public String pagina2(@PathVariable(value = "parametro")String parametro){
        return "pagina teste" + parametro;
    }


}
