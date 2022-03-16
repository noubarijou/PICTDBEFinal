package com.pifinal.alucar.service;

import com.pifinal.alucar.model.Funcoes;
import com.pifinal.alucar.repository.FuncoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncoesService {

    @Autowired
    private FuncoesRepository funcoesRepository;

    public Funcoes cadastrar(Funcoes f){ return funcoesRepository.save(f);}
    public List<Funcoes> buscarTodos(){ return funcoesRepository.findAll();}
    public Optional<Funcoes> buscar( Integer id) {return funcoesRepository.findById(id);}
    public void excluir(Integer id){ funcoesRepository.deleteById(id);}
    public Funcoes atualizar (Funcoes f){ return funcoesRepository.save(f);}

}
