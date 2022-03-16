package com.pifinal.alucar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Funcoes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 100)
    private String nome;

    @ManyToOne
    @JsonIgnoreProperties("funcoes")
    @ToString.Exclude
    @JoinColumn(name = "funcoes_id")
    private Usuario usuario;

}
