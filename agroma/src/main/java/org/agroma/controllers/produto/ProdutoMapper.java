package org.agroma.controllers.produto;

import org.agroma.entities.ProdutoEntity;

public class ProdutoMapper {

    public static ProdutoResponse toResponse(ProdutoEntity produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getQuantidade_atual(),
                produto.getNome(),
                produto.getMarca(),
                produto.getModelo()
        );
    }

    public static ProdutoEntity toEntityFromRequest(ProdutoRequest produtoRequest) {
        return new ProdutoEntity(
                null,
                produtoRequest.quantidade_atual(),
                produtoRequest.nome(),
                produtoRequest.marca(),
                produtoRequest.modelo(),
                produtoRequest.fornecedores()
        );
    }

    public static ProdutoEntity toEntityFromRequestExisting(ProdutoRequestExisting produtoRequestExisting) {
        return new ProdutoEntity(
                produtoRequestExisting.id(),
                produtoRequestExisting.quantidade_atual(),
                produtoRequestExisting.nome(),
                produtoRequestExisting.marca(),
                produtoRequestExisting.modelo(),
                produtoRequestExisting.fornecedores()
        );
    }
}
