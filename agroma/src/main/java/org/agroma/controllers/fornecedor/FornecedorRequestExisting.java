package org.agroma.controllers.fornecedor;

import org.agroma.entities.GuiaEntradaEntity;
import org.agroma.entities.ProdutoEntity;

import java.util.List;

public record FornecedorRequestExisting(
        Long id,
        String nome_social,
        String cnpj,
        String email,
        String telefone,
        List<ProdutoEntity> produtos,
        List<GuiaEntradaEntity> guias_entradas
) {
}
