package org.agroma.controllers.cliente;

public record ClienteRequestExisting(
        Long id,
        String nome,
        String email,
        String telefone
) {
}
