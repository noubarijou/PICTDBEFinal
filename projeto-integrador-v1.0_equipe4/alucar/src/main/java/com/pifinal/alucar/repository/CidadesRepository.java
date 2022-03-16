package com.pifinal.alucar.repository;

import com.pifinal.alucar.model.Cidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Integer> {
}
