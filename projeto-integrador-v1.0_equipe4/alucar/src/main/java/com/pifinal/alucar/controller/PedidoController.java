package com.pifinal.alucar.controller;


import com.pifinal.alucar.model.Pedido;
import com.pifinal.alucar.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", allowedHeaders = " ")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> Cadastrar (@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.cadastrar(pedido));
    }

    @GetMapping
    public List<Pedido> buscarTodos() {return pedidoService.buscarTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.buscar(id));
    }

    @PutMapping
    public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido) {
        ResponseEntity<Pedido> response = null;
        if (pedido.getId() != null && pedidoService.buscar(pedido.getId()).isPresent())
            response = ResponseEntity.ok(pedidoService.atualizar(pedido));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir (@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if (pedidoService.buscar(id).isPresent()) {
            pedidoService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pedido excluído");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
