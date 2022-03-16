package com.pifinal.alucar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cidades implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String pais;

    @ManyToOne
    @JsonIgnoreProperties("cidades")
    @ToString.Exclude
    @JoinColumn(name = "cidades_id")
    private Pedido pedido;




}
