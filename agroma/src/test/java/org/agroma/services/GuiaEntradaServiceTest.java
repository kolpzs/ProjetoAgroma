package org.agroma.services;

import jakarta.persistence.EntityNotFoundException;
import org.agroma.entities.GuiaEntradaEntity;
import org.agroma.repositories.GuiaEntradaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GuiaEntradaServiceTest {

    @InjectMocks
    private GuiaEntradaService guiaEntradaService;

    @Mock
    private GuiaEntradaRepository guiaEntradaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvarGuiaEntrada() {
        GuiaEntradaEntity guiaEntrada = new GuiaEntradaEntity();
        guiaEntrada.setId(1L);
        guiaEntrada.setDescricao("Nova Guia");

        when(guiaEntradaRepository.save(any(GuiaEntradaEntity.class))).thenReturn(guiaEntrada);

        GuiaEntradaEntity result = guiaEntradaService.salvarGuiaEntrada(guiaEntrada);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Nova Guia", result.getDescricao());
        verify(guiaEntradaRepository, times(1)).save(guiaEntrada);
    }

    @Test
    void testBuscarPorId() {
        GuiaEntradaEntity guiaEntrada = new GuiaEntradaEntity();
        guiaEntrada.setId(1L);

        when(guiaEntradaRepository.findById(1L)).thenReturn(Optional.of(guiaEntrada));

        GuiaEntradaEntity result = guiaEntradaService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(guiaEntradaRepository, times(1)).findById(1L);
    }

    @Test
    void testBuscarPorId_NotFound() {
        when(guiaEntradaRepository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> guiaEntradaService.buscarPorId(1L));

        assertEquals("Guia de Entrada não encontrada com ID: 1", exception.getMessage());
        verify(guiaEntradaRepository, times(1)).findById(1L);
    }

    @Test
    void testListarTodas() {
        GuiaEntradaEntity guia1 = new GuiaEntradaEntity();
        guia1.setId(1L);
        GuiaEntradaEntity guia2 = new GuiaEntradaEntity();
        guia2.setId(2L);

        when(guiaEntradaRepository.findAll()).thenReturn(Arrays.asList(guia1, guia2));

        List<GuiaEntradaEntity> result = guiaEntradaService.listarTodas();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(guiaEntradaRepository, times(1)).findAll();
    }

    @Test
    void testDeletarPorId() {
        when(guiaEntradaRepository.existsById(1L)).thenReturn(true);
        doNothing().when(guiaEntradaRepository).deleteById(1L);

        guiaEntradaService.deletarPorId(1L);

        verify(guiaEntradaRepository, times(1)).existsById(1L);
        verify(guiaEntradaRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeletarPorId_NotFound() {
        when(guiaEntradaRepository.existsById(1L)).thenReturn(false);

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> guiaEntradaService.deletarPorId(1L));

        assertEquals("Guia de Entrada não encontrada com ID: 1", exception.getMessage());
        verify(guiaEntradaRepository, times(1)).existsById(1L);
        verify(guiaEntradaRepository, never()).deleteById(1L);
    }
}
