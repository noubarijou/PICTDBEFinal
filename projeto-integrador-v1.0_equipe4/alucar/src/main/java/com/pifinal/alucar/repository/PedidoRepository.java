package com.pifinal.alucar.repository;

import com.pifinal.alucar.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Pedido cadastrar(Pedido c);
}
