package com.pifinal.alucar.controller;


import com.pifinal.alucar.model.Usuario;
import com.pifinal.alucar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar (@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.cadastrar(usuario));
    }

    @GetMapping
    public List<Usuario> buscarTodos() {return usuarioService.buscarTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscar(id));
    }

    @PutMapping()
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        ResponseEntity<Usuario> response = null;
        if (usuario.getId() != null && usuarioService.buscar(usuario.getId()).isPresent())
            response = ResponseEntity.ok(usuarioService.atualizar(usuario));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir (@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if(usuarioService.buscar(id).isPresent()) {
            usuarioService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário excluído");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  response;
    }

}














