package org.agroma.controllers.login;

public record LoginRequest(
        String login,
        String senha
) {
}
