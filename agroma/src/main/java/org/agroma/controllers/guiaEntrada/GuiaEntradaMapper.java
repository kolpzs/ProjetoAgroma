package org.agroma.controllers.guiaEntrada;

import org.agroma.entities.GuiaEntradaEntity;

public class GuiaEntradaMapper {

    public static GuiaEntradaResponse toResponse(GuiaEntradaEntity guiaEntrada) {
        return new GuiaEntradaResponse(
                guiaEntrada.getId(),
                guiaEntrada.getData(),
                guiaEntrada.getValor(),
                guiaEntrada.getQuantidade(),
                guiaEntrada.getProduto(),
                guiaEntrada.getFornecedor()
        );
    }

    public static GuiaEntradaEntity toEntityFromRequest(GuiaEntradaRequest guiaEntrada) {
        return new GuiaEntradaEntity(
                null,
                guiaEntrada.data(),
                guiaEntrada.valor(),
                guiaEntrada.quantidade(),
                guiaEntrada.produto(),
                guiaEntrada.fornecedor()
        );
    }

    public static GuiaEntradaEntity toEntityFromRequestExisting(GuiaEntradaRequestExisting guiaEntrada) {
        return new GuiaEntradaEntity(
                guiaEntrada.id(),
                guiaEntrada.data(),
                guiaEntrada.valor(),
                guiaEntrada.quantidade(),
                guiaEntrada.produto(),
                guiaEntrada.fornecedor()
        );
    }
}
