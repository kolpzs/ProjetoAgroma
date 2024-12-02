package org.agroma.controllers.pessoa;

public record PessoaResponse(
        Long id,
        String nome,
        int idade,
        String doc
) {
}