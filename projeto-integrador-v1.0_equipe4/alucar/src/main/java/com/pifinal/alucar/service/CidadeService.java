package com.pifinal.alucar.service;

import com.pifinal.alucar.model.Cidades;
import com.pifinal.alucar.repository.CidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadesRepository cidadesRepository;

    public Cidades cadastrar (Cidades c){ return cidadesRepository.save(c);}
    public List<Cidades> buscarTodos(){return cidadesRepository.findAll();}
    public Optional<Cidades> buscar(Integer id){ return cidadesRepository.findById(id);}
    public void excluir(Integer id){ cidadesRepository.deleteById(id);}
    public Cidades atualizar(Cidades c){ return cidadesRepository.save(c);}

}
