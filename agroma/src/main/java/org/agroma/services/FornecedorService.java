package org.agroma.services;

import org.agroma.entities.FornecedorEntity;
import org.agroma.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorEntity save(FornecedorEntity fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public FornecedorEntity findById(Long id) {
        return fornecedorRepository.findById(id).orElseThrow();
    }

    public List<FornecedorEntity> findAll() {
        return fornecedorRepository.findAll();
    }

    public void delete(FornecedorEntity fornecedor) {
        fornecedorRepository.delete(fornecedor);
    }

    public FornecedorEntity update(FornecedorEntity fornecedor) {
        if (fornecedorRepository.existsById(fornecedor.getId())) {
            FornecedorEntity fornecedorEntity = fornecedorRepository.findById(fornecedor.getId()).orElseThrow();
            fornecedorEntity.setNome_social(fornecedor.getNome_social());
            fornecedorEntity.setDescricao(fornecedor.getDescricao());
            fornecedorEntity.setCnpj(fornecedor.getCnpj());
            fornecedorEntity.setTelefone(fornecedor.getTelefone());
            fornecedorEntity.setEmail(fornecedor.getEmail());
            return fornecedorRepository.save(fornecedorEntity);
        }
        return null;
    }
}
