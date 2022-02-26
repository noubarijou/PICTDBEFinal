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
    private String url_imagem;

    @Column(nullable = false)
    private int qtde_assento;

    @Column(nullable = false)
    private int ar_condicionado;

    @Column(nullable = false)
    private int qtde_porta;

    @Column(nullable = false)
    private String tipo_combustivel;

    @Column(nullable = false)
    private int cambio;

    @Column(nullable = false)
    private String motor;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private int unid_disponiveis;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido_id;


    @OneToMany(mappedBy = "carro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carro")
    @ToString.Exclude
    private Set<Pedido> pedido = new HashSet<>();

}
