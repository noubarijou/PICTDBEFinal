package com.pifinal.alucar.controller;

import com.pifinal.alucar.model.Cidades;
import com.pifinal.alucar.model.Funcoes;
import com.pifinal.alucar.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
@CrossOrigin(origins = "*",allowedHeaders = " ")
public class CidadesController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidades> cadastrar(@RequestBody Cidades cidades){
        return ResponseEntity.ok(cidadeService.cadastrar(cidades));
    }

    @GetMapping
    public List<Cidades> buscarTodos(){return cidadeService.buscarTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cidades>> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(cidadeService.buscar(id));
    }

    @PutMapping
    public ResponseEntity<Cidades> atualizar(@RequestBody Cidades cidades){
        ResponseEntity<Cidades> response = null;
        if(cidades.getId() != null && cidadeService.buscar(cidades.getId()).isPresent())
            response = ResponseEntity.ok(cidadeService.atualizar(cidades));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if(cidadeService.buscar(id).isPresent()){
            cidadeService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cidade excluida");
        }else{
            response =ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
