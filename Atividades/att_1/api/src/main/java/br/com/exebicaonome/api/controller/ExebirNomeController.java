package br.com.exebicaonome.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meu-nome")
public class ExebirNomeController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String exebirNome(){

        return "Danilo Pereira";

    }

}
