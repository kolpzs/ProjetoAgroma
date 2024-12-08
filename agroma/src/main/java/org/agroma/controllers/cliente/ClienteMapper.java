package org.agroma.controllers.cliente;

import org.agroma.entities.ClienteEntity;

public class ClienteMapper {

    public static ClienteResponse toResponse(ClienteEntity clienteEntity) {
        return new ClienteResponse(
                clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getCpf(),
                clienteEntity.getEmail(),
                clienteEntity.getTelefone(),
                clienteEntity.getGuias_saidas()
        );
    }

    public static ClienteEntity toEntityFromRequest(ClienteRequest clienteRequest) {
        return new ClienteEntity(
                null,
                clienteRequest.nome(),
                clienteRequest.cpf(),
                clienteRequest.email(),
                clienteRequest.telefone(),
                clienteRequest.guias_saidas()
        );
    }

    public static ClienteEntity toEntityFromRequestExisting(ClienteRequestExisting clienteRequestExisting) {
        return new ClienteEntity(
                clienteRequestExisting.id(),
                clienteRequestExisting.nome(),
                clienteRequestExisting.cpf(),
                clienteRequestExisting.email(),
                clienteRequestExisting.telefone(),
                clienteRequestExisting.guias_saidas()
        );
    }
}
