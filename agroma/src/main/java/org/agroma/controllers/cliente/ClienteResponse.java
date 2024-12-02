package org.agroma.controllers.cliente;

public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String telefone
) {
}
