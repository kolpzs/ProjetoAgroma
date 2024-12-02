package org.agroma.services;

import jakarta.persistence.EntityNotFoundException;
import org.agroma.entities.GuiaSaidaEntity;
import org.agroma.repositories.GuiaSaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuiaSaidaService {

    @Autowired
    private GuiaSaidaRepository guiaSaidaRepository;

    public GuiaSaidaEntity salvarGuiaSaida(GuiaSaidaEntity guiaSaida) {
        return guiaSaidaRepository.save(guiaSaida);
    }

    public GuiaSaidaEntity buscarPorId(Long id) {
        return guiaSaidaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guia de Saída não encontrada com ID: " + id));
    }

    public List<GuiaSaidaEntity> listarTodas() {
        return guiaSaidaRepository.findAll();
    }

    public void deletarPorId(Long id) {
        if (!guiaSaidaRepository.existsById(id)) {
            throw new EntityNotFoundException("Guia de Saída não encontrada com ID: " + id);
        }
        guiaSaidaRepository.deleteById(id);
    }
}
