package org.agroma.controllers.cliente;

import org.agroma.entities.ClienteEntity;

public class ClienteMapper {

    public static ClienteResponse toResponse(ClienteEntity clienteEntity) {
        return new ClienteResponse(
                clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getEmail(),
                clienteEntity.getTelefone()
        );
    }

    public static ClienteEntity toEntityFromRequest(ClienteRequest clienteRequest) {
        return new ClienteEntity(
                null,
                clienteRequest.nome(),
                clienteRequest.email(),
                clienteRequest.telefone()
        );
    }

    public static ClienteEntity toEntityFromRequestExisting(ClienteRequestExisting clienteRequestExisting) {
        return new ClienteEntity(
                clienteRequestExisting.id(),
                clienteRequestExisting.nome(),
                clienteRequestExisting.email(),
                clienteRequestExisting.telefone()
        );
    }
}
