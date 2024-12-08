package org.agroma.services;

import org.agroma.entities.ClienteEntity;
import org.agroma.repositories.ClienteRepository;
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

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(1L);
        cliente.setNome("Teste Cliente");

        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(cliente);

        ClienteEntity result = clienteService.save(cliente);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Teste Cliente", result.getNome());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testFindById() {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(1L);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        ClienteEntity result = clienteService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        ClienteEntity cliente1 = new ClienteEntity();
        cliente1.setId(1L);
        ClienteEntity cliente2 = new ClienteEntity();
        cliente2.setId(2L);

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<ClienteEntity> result = clienteService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testUpdate() {
        ClienteEntity base = new ClienteEntity();
        base.setId(1L);
        base.setNome("Antigo Nome");

        ClienteEntity updated = new ClienteEntity();
        updated.setId(1L);
        updated.setNome("Novo Nome");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(base));
        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(updated);

        ClienteEntity result = clienteService.update(updated);

        assertNotNull(result);
        assertEquals("Novo Nome", result.getNome());
        verify(clienteRepository, times(1)).findById(1L);
        verify(clienteRepository, times(1)).save(base);
    }

    @Test
    void testDelete() {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(1L);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        doNothing().when(clienteRepository).delete(cliente);

        String result = clienteService.delete(1L);

        assertEquals("Cliente removido com sucesso!", result);
        verify(clienteRepository, times(1)).findById(1L);
        verify(clienteRepository, times(1)).delete(cliente);
    }
}
