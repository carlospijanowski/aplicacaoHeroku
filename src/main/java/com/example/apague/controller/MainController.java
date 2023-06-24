package com.example.apague.controller;

import com.example.apague.model.ObjetoCorreios;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping()
public class MainController {
    @GetMapping("/cep/{cep}")
    public String teste(@PathVariable String cep) {

        RestTemplate restTemplate = new RestTemplate();
        Object forObject = restTemplate.getForObject("https://viacep.com.br/ws/"+cep+"/json/", Object.class);

//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            objectMapper.readValue(forObject.toString(), ObjetoCorreios.class);
//        } catch (JsonProcessingException e) {
//            System.out.println("nao convertido!!!");
//        }

        System.out.println(forObject);

        return "<html><b><font color=red><font size = 200>fiz esse endPoint retornando apenas uma string" +
                "</font></b><br><br>"+forObject+"</html>";
    }


}
