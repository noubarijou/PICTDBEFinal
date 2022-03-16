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
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int unid_disponiveis;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "imagens_id")
    private Imagens imagens;

    @ManyToOne
    @JoinColumn(name = "caracteristicas_id")
    private Caracteristicas caracteristicas;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido_id;


    @OneToMany(mappedBy = "carro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carro")
    @ToString.Exclude
    private Set<Pedido> pedido = new HashSet<>();

}
