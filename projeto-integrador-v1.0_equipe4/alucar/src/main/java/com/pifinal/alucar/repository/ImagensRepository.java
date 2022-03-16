package com.pifinal.alucar.repository;

import com.pifinal.alucar.model.Imagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagensRepository extends JpaRepository<Imagens, Integer> {
}
