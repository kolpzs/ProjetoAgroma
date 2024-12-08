package org.agroma.controllers.produto;

import org.agroma.entities.FornecedorEntity;
import org.agroma.entities.GuiaEntradaEntity;
import org.agroma.entities.GuiaSaidaEntity;

import java.util.List;

public record ProdutoRequest(
        int quantidade_atual,
        String nome,
        String marca,
        String modelo,
        List<FornecedorEntity> fornecedores,
        List<GuiaEntradaEntity> guias_entradas,
        List<GuiaSaidaEntity> guias_saidas
) {
}
