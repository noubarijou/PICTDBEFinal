package com.pifinal.alucar.service;

import com.pifinal.alucar.model.Caracteristicas;
import com.pifinal.alucar.repository.CaracteristicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicasService {

    @Autowired
    private CaracteristicasRepository caracteristicasRepository;

    public Caracteristicas cadastrar(Caracteristicas c) { return caracteristicasRepository.save(c);}

    public List<Caracteristicas> buscarTodos() {return caracteristicasRepository.findAll();}

    public Optional<Caracteristicas> buscar(Integer id) {return caracteristicasRepository.findById(id);}

    public void excluir (Integer id) {caracteristicasRepository.deleteById(id);}

    public Caracteristicas atualizar (Caracteristicas c) {return caracteristicasRepository.save(c);}
}
