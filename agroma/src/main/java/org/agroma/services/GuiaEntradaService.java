package org.agroma.services;

import jakarta.persistence.EntityNotFoundException;
import org.agroma.entities.GuiaEntradaEntity;
import org.agroma.repositories.GuiaEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuiaEntradaService {

    @Autowired
    private GuiaEntradaRepository guiaEntradaRepository;

    public GuiaEntradaEntity salvarGuiaEntrada(GuiaEntradaEntity guiaEntrada) {
        return guiaEntradaRepository.save(guiaEntrada);
    }

    public GuiaEntradaEntity buscarPorId(Long id) {
        return guiaEntradaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guia de Entrada não encontrada com ID: " + id));
    }

    public List<GuiaEntradaEntity> listarTodas() {
        return guiaEntradaRepository.findAll();
    }

    public void deletarPorId(Long id) {
        if (!guiaEntradaRepository.existsById(id)) {
            throw new EntityNotFoundException("Guia de Entrada não encontrada com ID: " + id);
        }
        guiaEntradaRepository.deleteById(id);
    }
}
