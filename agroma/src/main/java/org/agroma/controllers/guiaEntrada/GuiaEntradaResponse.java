package org.agroma.controllers.guiaEntrada;

import org.agroma.entities.FornecedorEntity;
import org.agroma.entities.ProdutoEntity;

import java.util.Date;

public record GuiaEntradaResponse(
        Long id,
        Date data,
        float valor,
        int quantidade,
        ProdutoEntity produto,
        FornecedorEntity fornecedor
) {
}

