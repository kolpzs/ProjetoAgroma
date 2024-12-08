package org.agroma.services;

import org.agroma.entities.FornecedorEntity;
import org.agroma.repositories.FornecedorRepository;
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

class FornecedorServiceTest {

    @InjectMocks
    private FornecedorService fornecedorService;

    @Mock
    private FornecedorRepository fornecedorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        FornecedorEntity fornecedor = new FornecedorEntity();
        fornecedor.setId(1L);
        fornecedor.setNome_social("Fornecedor Teste");

        when(fornecedorRepository.save(any(FornecedorEntity.class))).thenReturn(fornecedor);

        FornecedorEntity result = fornecedorService.save(fornecedor);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Fornecedor Teste", result.getNome_social());
        verify(fornecedorRepository, times(1)).save(fornecedor);
    }

    @Test
    void testFindById() {
        FornecedorEntity fornecedor = new FornecedorEntity();
        fornecedor.setId(1L);

        when(fornecedorRepository.findById(1L)).thenReturn(Optional.of(fornecedor));

        FornecedorEntity result = fornecedorService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(fornecedorRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        FornecedorEntity fornecedor1 = new FornecedorEntity();
        fornecedor1.setId(1L);
        FornecedorEntity fornecedor2 = new FornecedorEntity();
        fornecedor2.setId(2L);

        when(fornecedorRepository.findAll()).thenReturn(Arrays.asList(fornecedor1, fornecedor2));

        List<FornecedorEntity> result = fornecedorService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(fornecedorRepository, times(1)).findAll();
    }

    @Test
    void testUpdate() {
        FornecedorEntity base = new FornecedorEntity();
        base.setId(1L);
        base.setNome_social("Nome Antigo");

        FornecedorEntity updated = new FornecedorEntity();
        updated.setId(1L);
        updated.setNome_social("Nome Atualizado");

        when(fornecedorRepository.findById(1L)).thenReturn(Optional.of(base));
        when(fornecedorRepository.save(any(FornecedorEntity.class))).thenReturn(updated);

        FornecedorEntity result = fornecedorService.update(updated);

        assertNotNull(result);
        assertEquals("Nome Atualizado", result.getNome_social());
        verify(fornecedorRepository, times(1)).findById(1L);
        verify(fornecedorRepository, times(1)).save(base);
    }

    @Test
    void testDelete() {
        FornecedorEntity fornecedor = new FornecedorEntity();
        fornecedor.setId(1L);

        when(fornecedorRepository.findById(1L)).thenReturn(Optional.of(fornecedor));
        doNothing().when(fornecedorRepository).delete(fornecedor);

        String result = fornecedorService.delete(1L);

        assertEquals("Fornecedor removido com sucesso!", result);
        verify(fornecedorRepository, times(1)).findById(1L);
        verify(fornecedorRepository, times(1)).delete(fornecedor);
    }
}
