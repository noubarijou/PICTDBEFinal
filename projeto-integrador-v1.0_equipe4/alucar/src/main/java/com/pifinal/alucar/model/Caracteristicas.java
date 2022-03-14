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
public class Caracteristicas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String qtde_porta;

    @Column(nullable = false)
    private int qtde_assento;

    @Column(nullable = false)
    private boolean ar_condicionado;

    @Column(nullable = false)
    private String tipo_combustivel;

    @Column(nullable = false)
    private String cambio;

    @Column(nullable = false)
    private String motor;

    @Column(nullable = false)
    private String cor;

    @OneToMany(mappedBy = "caracteristicas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("caracteristicas")
    @ToString.Exclude
    private Set<Carro> carros = new HashSet<>();

}
