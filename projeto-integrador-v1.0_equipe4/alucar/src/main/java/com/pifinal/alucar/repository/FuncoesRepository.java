package com.pifinal.alucar.repository;

import com.pifinal.alucar.model.Funcoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncoesRepository extends JpaRepository<Funcoes, Integer> {
}
