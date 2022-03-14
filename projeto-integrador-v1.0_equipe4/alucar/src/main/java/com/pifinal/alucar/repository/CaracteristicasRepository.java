package com.pifinal.alucar.repository;

import com.pifinal.alucar.model.Caracteristicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicasRepository extends JpaRepository<Caracteristicas, Integer> {
}
