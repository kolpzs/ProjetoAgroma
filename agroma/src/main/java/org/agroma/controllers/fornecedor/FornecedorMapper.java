package org.agroma.controllers.fornecedor;

import org.agroma.controllers.pessoa.PessoaRequestExisting;
import org.agroma.entities.FornecedorEntity;
import org.agroma.entities.PessoaEntity;

public class FornecedorMapper {

    public static FornecedorResponse toResponse(FornecedorEntity fornecedor) {
        return new FornecedorResponse(
                fornecedor.getId(),
                fornecedor.getNome_social(),
                fornecedor.getCnpj(),
                fornecedor.getEmail(),
                fornecedor.getTelefone()
        );
    }

    public static FornecedorEntity toEntityFromRequest(FornecedorRequest fornecedor) {
        return new FornecedorEntity(
                null,
                fornecedor.nome_social(),
                fornecedor.cnpj(),
                fornecedor.email(),
                fornecedor.telefone(),
                fornecedor.produtos(),
                fornecedor.guias_entradas()
        );
    }

    public static FornecedorEntity toEntityFromRequestExisting(FornecedorRequestExisting fornecedor) {
        return new FornecedorEntity(
                fornecedor.id(),
                fornecedor.nome_social(),
                fornecedor.cnpj(),
                fornecedor.email(),
                fornecedor.telefone(),
                fornecedor.produtos(),
                fornecedor.guias_entradas()
        );
    }
}
