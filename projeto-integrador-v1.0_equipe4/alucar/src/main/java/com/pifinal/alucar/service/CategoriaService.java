package com.pifinal.alucar.service;
import com.pifinal.alucar.model.Categoria;
import com.pifinal.alucar.model.Pedido;
import com.pifinal.alucar.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrar(Categoria c) { return categoriaRepository.save(c);}

    public List<Categoria> buscarTodos() {return categoriaRepository.findAll();}

    public Optional<Categoria> buscar (Integer id) {return categoriaRepository.findById(id);}

    public void excluir(Integer id) {categoriaRepository.deleteById(id);}

    public Categoria atualizar (Categoria c) {return categoriaRepository.save(c);}
}
