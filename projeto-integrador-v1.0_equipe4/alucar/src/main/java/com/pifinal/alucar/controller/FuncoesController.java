package com.pifinal.alucar.controller;

import com.pifinal.alucar.model.Funcoes;
import com.pifinal.alucar.service.FuncoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncoesController {

    @Autowired
    private FuncoesService funcoesService;

    @PostMapping
    public ResponseEntity<Funcoes> cadastrar(@RequestBody Funcoes funcoes){
        return ResponseEntity.ok(funcoesService.cadastrar(funcoes));
    }

    @GetMapping
    public List<Funcoes> buscarTodos(){ return funcoesService.buscarTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Funcoes>> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(funcoesService.buscar(id));
    }

    @PutMapping
    public ResponseEntity<Funcoes> atualizar(@RequestBody Funcoes funcoes){
        ResponseEntity<Funcoes> response = null;
        if(funcoes.getId() != null && funcoesService.buscar(funcoes.getId()).isPresent())
            response = ResponseEntity.ok(funcoesService.atualizar(funcoes));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if(funcoesService.buscar(id).isPresent()){
            funcoesService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Função excluida com sucesso");
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
