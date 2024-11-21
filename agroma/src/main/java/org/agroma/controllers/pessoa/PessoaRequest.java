package org.agroma.controllers.pessoa;

import java.util.List;

public record PessoaRequest(
        String nome,
        int idade,
        String doc,
        List<Long> roles,
        String senha
) {
}
