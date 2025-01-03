package org.agroma.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
@Entity(name = "fornecedores")
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome_social;

    @Column(nullable = false)
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")
    // 00.000.000/0000-00
    private String cnpj;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    // email@email.com
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}")
    // (45)99999-9399
    private String telefone;

    @ManyToMany(mappedBy = "fornecedores")
    @JsonIgnoreProperties({"produtos", "fornecedores", "enderecos", "funcionarios", "adms", "guias_entradas", "guias_saidas", "clientes"})
    private List<ProdutoEntity> produtos;

    @OneToMany(mappedBy = "fornecedor")
    @JsonIgnoreProperties({"produtos", "fornecedores", "enderecos", "funcionarios", "adms", "guias_entradas", "guias_saidas", "clientes"})
    private List<GuiaEntradaEntity> guias_entradas;

}

