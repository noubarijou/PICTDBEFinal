package com.pifinal.alucar.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Where;

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
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    private Date data_nascimento;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String cnh;

    @Column(nullable = false, length = 15)
    private String telefone;

    @OneToMany(mappedBy = "usuario")
    //@JoinColumn(name = "endereco_id")
    private Set<Endereco> endereco = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    //@JoinColumn (name = "funcoes_id")
    private Set<Funcoes> funcoes = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario_id")
    @ToString.Exclude
    private Set<Pedido> pedido = new HashSet<>();


}
