package com.pifinal.alucar.controller;
import com.pifinal.alucar.model.Carro;
import com.pifinal.alucar.model.Pedido;
import com.pifinal.alucar.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<Carro> cadastrar (@RequestBody Carro carro) {
        return ResponseEntity.ok(carroService.cadastrar(carro));
    }

    @GetMapping
    public List<Carro> buscarTodos() {return carroService.buscarTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Carro>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(carroService.buscar(id));
    }

    @PutMapping()
    public ResponseEntity<Carro> atualizar(@RequestBody Carro carro) {
        ResponseEntity<Carro> response = null;
        if (carro.getId() != null && carroService.buscar(carro.getId()).isPresent())
            response = ResponseEntity.ok(carroService.atualizar(carro));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir (@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if (carroService.buscar(id).isPresent()) {
            carroService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Carro excluído");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
