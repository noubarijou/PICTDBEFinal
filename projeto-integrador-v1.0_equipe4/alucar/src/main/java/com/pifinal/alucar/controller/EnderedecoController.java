package com.pifinal.alucar.controller;


import com.pifinal.alucar.model.Endereco;
import com.pifinal.alucar.model.Usuario;
import com.pifinal.alucar.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*", allowedHeaders = " ")
public class EnderedecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> cadastrar (@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.cadastrar(endereco));
    }

    @GetMapping
    public List<Endereco> buscarTodos() {return enderecoService.buscarTodos(); }

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Endereco>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(enderecoService.buscar(id));
    }

    @PutMapping
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco) {
        ResponseEntity<Endereco> response = null;
        if (endereco.getId() != null && enderecoService.buscar(endereco.getId()).isPresent())
            response = ResponseEntity.ok(enderecoService.atualizar(endereco));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir (@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if(enderecoService.buscar(id).isPresent()){
            enderecoService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Endereço excluído");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }















}
