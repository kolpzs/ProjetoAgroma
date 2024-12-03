package org.agroma.controllers.produto;

public record ProdutoResponse(
        Long id,
        int quantidade_atual,
        String nome,
        String marca,
        String modelo
) {
}
