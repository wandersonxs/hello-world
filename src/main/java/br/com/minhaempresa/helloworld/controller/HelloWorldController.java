package br.com.minhaempresa.helloworld.controller;

import br.com.minhaempresa.helloworld.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "pessoas/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> getPessoaPorId(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(new Pessoa(id, "Wanderson Server" , 35));
    }

    @RequestMapping(value = "pessoas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        pessoa.setId(10000L);
        pessoa.setNome(pessoa.getNome() + " SERVER ");
        pessoa.setIdade(pessoa.getIdade() + 50);
        return new ResponseEntity(pessoa, HttpStatus.CREATED);
    }

}
