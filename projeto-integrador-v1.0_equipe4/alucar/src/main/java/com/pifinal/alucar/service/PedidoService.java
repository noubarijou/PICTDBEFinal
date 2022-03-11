package com.pifinal.alucar.service;

import com.pifinal.alucar.model.Pedido;
import com.pifinal.alucar.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido cadastrar (Pedido p) {
        return pedidoRepository.save(p);
    }

    public List<Pedido> buscarTodos() {return pedidoRepository.findAll();}

    public Optional<Pedido> buscar (Integer id) {return pedidoRepository.findById(id);}

    public void excluir(Integer id) {pedidoRepository.deleteById(id);}

    public Pedido atualizar (Pedido pedido) {return pedidoRepository.save(pedido);}

}
