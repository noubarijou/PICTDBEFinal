package com.pifinal.alucar.controller;

import com.pifinal.alucar.model.Imagens;
import com.pifinal.alucar.service.ImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ImagensController {
    @Autowired
    private ImagensService imagensService;

    @PostMapping
    public ResponseEntity<Imagens> cadastrar (@RequestBody Imagens imagens) {
        return ResponseEntity.ok(imagensService.cadastrar(imagens));
    }

    @GetMapping
    public ResponseEntity<List<Imagens>> buscarTodos() {return ResponseEntity.ok(imagensService.buscarTodos());}

    @GetMapping ("/{id}")
    public ResponseEntity <Optional<Imagens>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(imagensService.buscar(id));
    }

    //@PutMapping()
    //public ResponseEntity<Imagens> atualizar(RequestBody Imagens imagens) {
      //  ResponseEntity<Imagens> response = null;
        //if (imagens.getId() != null && imagensService.buscar(imagens.getId()).isPresent())
         //   response = ResponseEntity.ok(imagensService.atualizar(imagens));
        //else
          //  response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        //return response;
    //}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir (@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if(imagensService.buscar(id).isPresent()) {
            imagensService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagem excluída");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


}






































