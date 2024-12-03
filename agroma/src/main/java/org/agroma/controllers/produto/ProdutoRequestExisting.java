package org.agroma.controllers.produto;

import org.agroma.entities.FornecedorEntity;

import java.util.List;

public record ProdutoRequestExisting(
        Long id,
        int quantidade_atual,
        String nome,
        String marca,
        String modelo,
        List<FornecedorEntity> fornecedores
) {
}