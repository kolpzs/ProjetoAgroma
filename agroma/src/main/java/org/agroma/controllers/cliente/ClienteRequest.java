package org.agroma.controllers.cliente;

import org.agroma.entities.GuiaSaidaEntity;

import java.util.List;

public record ClienteRequest(
        String nome,
        String cpf,
        String email,
        String telefone,
        List<GuiaSaidaEntity> guias_saidas
) {
}
