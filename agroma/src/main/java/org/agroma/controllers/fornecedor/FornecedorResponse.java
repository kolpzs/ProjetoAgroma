package org.agroma.controllers.fornecedor;

public record FornecedorResponse(
        Long id,
        String nome_social,
        String cnpj,
        String email,
        String telefone
) {
}
