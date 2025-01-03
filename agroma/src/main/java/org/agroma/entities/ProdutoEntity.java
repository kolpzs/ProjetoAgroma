package org.agroma.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(0)
    @Column(nullable = false)
    private int quantidade_atual;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @ManyToMany
    @JoinTable(
            name = "produto_fornecedor",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "avaliador_id")
    )
    @JsonIgnoreProperties({"produtos", "fornecedores", "enderecos", "funcionarios", "adms", "guias_entradas", "guias_saidas", "clientes"})
    private List<FornecedorEntity> fornecedores;

    @OneToMany(mappedBy = "produto")
    @JsonIgnoreProperties({"produtos", "fornecedores", "enderecos", "funcionarios", "adms", "guias_entradas", "guias_saidas", "clientes"})
    private List<GuiaEntradaEntity> guias_entradas;

    @OneToMany(mappedBy = "produto")
    @JsonIgnoreProperties({"produtos", "fornecedores", "enderecos", "funcionarios", "adms", "guias_entradas", "guias_saidas", "clientes"})
    private List<GuiaSaidaEntity> guias_saidas;
}
