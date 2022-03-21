package com.pifinal.alucar.controller;

import com.pifinal.alucar.model.Caracteristicas;
import com.pifinal.alucar.service.CaracteristicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caracteristicas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CaracteristicasController {
    @Autowired
    private CaracteristicasService caracteristicasService;

    @PostMapping
    public ResponseEntity<Caracteristicas> cadastrar (@RequestBody Caracteristicas caracteristicas) {
        return ResponseEntity.ok(caracteristicasService.cadastrar(caracteristicas));

    }

    @GetMapping
    public ResponseEntity<List<Caracteristicas>> buscarTodos() {return ResponseEntity.ok(caracteristicasService.buscarTodos());}

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Caracteristicas>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(caracteristicasService.buscar(id));
    }

    @PutMapping()
    public ResponseEntity<Caracteristicas> atualizar(@RequestBody Caracteristicas caracteristicas) {
        ResponseEntity<Caracteristicas> response = null;
        if (caracteristicas.getId() != null && caracteristicasService.buscar(caracteristicas.getId()).isPresent())
            response = ResponseEntity.ok(caracteristicasService.atualizar(caracteristicas));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir (@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if(caracteristicasService.buscar(id).isPresent()) {
            caracteristicasService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Caracteristica excluída");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}




















































