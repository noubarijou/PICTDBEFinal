package com.pifinal.alucar.service;

import com.pifinal.alucar.model.Imagens;
import com.pifinal.alucar.repository.ImagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagensService {

    @Autowired
    private ImagensRepository imagensRepository;

    public Imagens cadastrar(Imagens i) { return imagensRepository.save(i);}

    public List<Imagens> buscarTodos() { return imagensRepository.findAll();}

    public Optional<Imagens> buscar (Integer id) { return imagensRepository.findById(id);}

    public void excluir(Integer id) {imagensRepository.deleteById(id);}

    public Imagens atualizar (Imagens i) { return imagensRepository.save(i);}

}
