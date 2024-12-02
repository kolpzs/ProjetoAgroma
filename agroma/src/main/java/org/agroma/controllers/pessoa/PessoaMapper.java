package org.agroma.controllers.pessoa;

import org.agroma.entities.PessoaEntity;

public class PessoaMapper {

    public static PessoaResponse toResponse(PessoaEntity pessoa) {
        return new PessoaResponse(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getIdade(),
                pessoa.getDocumento()
        );
    }

    public static PessoaEntity toEntityFromRequest(PessoaRequest pessoaRequest) {
        return new PessoaEntity(
                null,
                pessoaRequest.nome(),
                pessoaRequest.idade(),
                pessoaRequest.doc(),
                pessoaRequest.senha()
        );
    }

    public static PessoaEntity toEntityFromRequestExisting(PessoaRequestExisting pessoaRequest) {
        return new PessoaEntity(
                pessoaRequest.id(),
                pessoaRequest.nome(),
                pessoaRequest.idade(),
                pessoaRequest.doc(),
                pessoaRequest.senha()
        );
    }
}