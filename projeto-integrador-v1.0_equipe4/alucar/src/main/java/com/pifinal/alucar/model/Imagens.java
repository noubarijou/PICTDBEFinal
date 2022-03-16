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

public class Imagens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String url_imagem;

    @OneToMany(mappedBy = "imagens", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("imagens")
    @ToString.Exclude
    private Set<Carro> carros = new HashSet<>();



}
