package org.agroma.controllers.login;

public record LoginRequest(
        String nome,
        String senha
) {
}
