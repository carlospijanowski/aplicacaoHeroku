package com.example.apague.controller;

import com.example.apague.dao.CepDAOImpl;
import com.example.apague.dao.DespesaDAOImpl;
import com.example.apague.model.Categoria;
import com.example.apague.model.Despesa;
import com.example.apague.model.ObjetoCorreios;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequestMapping()
public class MainController {
    @GetMapping("/cep/{cep}")
    public String teste(@PathVariable String cep) {

        RestTemplate restTemplate = new RestTemplate();
        ObjetoCorreios forObject = restTemplate.getForObject("https://viacep.com.br/ws/"+cep+"/json/", ObjetoCorreios.class);

//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            objectMapper.readValue(forObject.toString(), ObjetoCorreios.class);
//        } catch (JsonProcessingException e) {
//            System.out.println("nao convertido!!!");
//        }

        System.out.println(forObject);

        Despesa despesa = new Despesa();
        despesa.setDescricao(forObject.getLogradouro());
        despesa.setCategoria(Categoria.ALIMENTACAO);
        despesa.setValor(1200);
        despesa.setData(LocalDate.of(2023,06,22));

        DespesaDAOImpl despesaDAO = new DespesaDAOImpl();
        Despesa save = despesaDAO.save(despesa);

        System.out.println(save.toString());


        CepDAOImpl cepDAO = new CepDAOImpl();
        cepDAO.save(forObject);

        String html = """
                <html>
                    <b><font color=red><font size = 200>SUCESSO!!!</font></b>
                    <br>
                    <br> 
                    """+forObject+"""
                </html>
        """;

        return html;
    }


}
