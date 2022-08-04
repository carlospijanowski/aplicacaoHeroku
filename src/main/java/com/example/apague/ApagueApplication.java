package com.example.apague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApagueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApagueApplication.class, args);
    }

    @RequestMapping("/")
    public String pagina1(){
        return "pagina sem layout 2";
    }

    @RequestMapping("/teste/{parametro}")
    public String pagina2(@PathVariable(value = "parametro")String parametro){
        return "pagina teste" + parametro;
    }
}
