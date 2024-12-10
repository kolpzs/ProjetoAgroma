package org.agroma.services;

import org.agroma.entities.GuiaEntradaEntity;
import org.agroma.repositories.GuiaEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuiaEntradaService {

    @Autowired
    private GuiaEntradaRepository guiaEntradaRepository;

    public GuiaEntradaEntity save(GuiaEntradaEntity guiaEntradaEntity) {
        return guiaEntradaRepository.save(guiaEntradaEntity);
    }

    public GuiaEntradaEntity findById(Long id) {
        return guiaEntradaRepository.findById(id).orElseThrow();
    }

    public List<GuiaEntradaEntity> findAll() {
        return guiaEntradaRepository.findAll();
    }

    public GuiaEntradaEntity update(GuiaEntradaEntity guiaEntradaEntity) {
        GuiaEntradaEntity guia = findById(guiaEntradaEntity.getId());
        if (guia != null) {
            guia.setData(guiaEntradaEntity.getData());
            guia.setValor(guiaEntradaEntity.getValor());
            guia.setProduto(guiaEntradaEntity.getProduto());
            guia.setQuantidade(guiaEntradaEntity.getQuantidade());
            guia.setFornecedor(guiaEntradaEntity.getFornecedor());
            return guiaEntradaRepository.save(guia);
        }
        return null;
    }
}
