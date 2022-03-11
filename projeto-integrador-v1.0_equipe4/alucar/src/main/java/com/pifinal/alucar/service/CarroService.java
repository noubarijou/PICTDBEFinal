package com.pifinal.alucar.service;
import com.pifinal.alucar.model.Carro;
import com.pifinal.alucar.model.Pedido;
import com.pifinal.alucar.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro cadastrar(Carro c) {return carroRepository.save(c);}

    public List<Carro> buscarTodos() {return carroRepository.findAll();}

    public Optional<Carro> buscar (Integer id) {return carroRepository.findById(id);}

    public void excluir(Integer id) {carroRepository.deleteById(id);}

    public Carro atualizar (Carro c) {return carroRepository.save(c);}

}
