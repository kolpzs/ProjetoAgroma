package org.agroma.services;

import org.agroma.entities.ClienteEntity;
import org.agroma.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteEntity findById(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteEntity update(ClienteEntity cliente) {
        if (clienteRepository.existsById(cliente.getId())) {
            ClienteEntity clienteEntity = clienteRepository.findById(cliente.getId()).orElseThrow();
            clienteEntity.setNome(cliente.getNome());
            clienteEntity.setEmail(cliente.getEmail());
            clienteEntity.setTelefone(cliente.getTelefone());
            return clienteRepository.save(clienteEntity);
        }
        return null;
    }
}
