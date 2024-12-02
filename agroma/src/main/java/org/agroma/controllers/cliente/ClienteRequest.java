package org.agroma.controllers.cliente;

public record ClienteRequest(
        String nome,
        String email,
        String telefone
) {
}
