package com.pifinal.alucar.repository;

import com.pifinal.alucar.model.Endereco;
import com.pifinal.alucar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
