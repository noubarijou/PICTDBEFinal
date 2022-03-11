package com.pifinal.alucar.controller;
import com.pifinal.alucar.model.Categoria;
import com.pifinal.alucar.repository.CategoriaRepository;
import com.pifinal.alucar.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = " ")

public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar (@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.cadastrar(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos() {return ResponseEntity.ok(categoriaService.buscarTodos());}

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Categoria>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.buscar(id));
    }

    @PutMapping()
    public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria) {
        ResponseEntity<Categoria> response = null;
        if (categoria.getId() != null && categoriaService.buscar(categoria.getId()).isPresent())
            response = ResponseEntity.ok(categoriaService.atualizar(categoria));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir (@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if (categoriaService.buscar(id).isPresent()) {
            categoriaService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoria excluída");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
