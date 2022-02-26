package com.pifinal.alucar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 300)
    private String rua;

    @Column(nullable = false, length = 30)
    private String cidade;

    @Column(nullable = false, length = 12)
    private String cep;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, length = 20)
    private String pais;

    @ManyToOne
    @JsonIgnoreProperties("endereco")
    @ToString.Exclude
    @JoinColumn(name = "endereco_id")
    private Usuario usuario;
}
