package com.pifinal.alucar.model;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date data_retirada;

    @Column(nullable = false)
    private String horario_retirada;

    @Column(nullable = false)
    private Date data_entrega;

    @Column(nullable = false)
    private String horario_entrega;


    @Column(nullable = false)
    private String local_retirada;

    @Column(nullable = false)
    private String local_entrega;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @OneToMany (mappedBy = "pedido")
    //@JoinColumn(name = "cidades_id")
    private Set<Cidades> cidades = new HashSet<>();

}
