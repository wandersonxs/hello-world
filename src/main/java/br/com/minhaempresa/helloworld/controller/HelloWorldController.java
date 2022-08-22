package br.com.minhaempresa.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(value = "hello-world", method = RequestMethod.GET)
    public String helloWorld(){
        System.out.println("PASSEI AQUI");
        return "Hello World!";
    }

    @RequestMapping(value = "hello-world-2", method = RequestMethod.GET)
    public String helloWorld2(@RequestParam(value = "nome", required = false ) String nome){
        System.out.println("PASSEI AQUI 2");
        return "Hello World! Tudo bem " + nome + " ?";
    }

}
