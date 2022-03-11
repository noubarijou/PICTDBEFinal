package com.pifinal.alucar.service;

import com.pifinal.alucar.model.Endereco;
import com.pifinal.alucar.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastrar(Endereco e) {
        return enderecoRepository.save(e);
    }

    public List<Endereco> buscarTodos() {return enderecoRepository.findAll();}

    public Optional<Endereco> buscar (Integer id) {return enderecoRepository.findById(id);}

    public void excluir(Integer id) {enderecoRepository.deleteById(id);}

    public Endereco atualizar (Endereco endereco) {return enderecoRepository.save(endereco);}


}
