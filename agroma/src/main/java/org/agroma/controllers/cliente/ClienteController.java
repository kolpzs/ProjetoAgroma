package org.agroma.controllers.cliente;

import org.agroma.services.ClienteService;
import org.agroma.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/save")
    public ResponseEntity<ClienteResponse> save(@RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity.ok(ClienteMapper.toResponse(clienteService.save(ClienteMapper.toEntityFromRequest(clienteRequest))));
    }
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/findById")
    public ResponseEntity<ClienteResponse> findById(@RequestParam Long id) {
        return ResponseEntity.ok(ClienteMapper.toResponse(clienteService.findById(id)));
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/findAll")
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ResponseEntity.ok(clienteService.findAll().stream().map(ClienteMapper::toResponse).collect(Collectors.toList()));
    }
    @PreAuthorize("hasRole('admin')")
    @PutMapping("/update")
    public ResponseEntity<ClienteResponse> update(@RequestBody ClienteRequestExisting clienteRequest) {
        clienteService.update(ClienteMapper.toEntityFromRequestExisting(clienteRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
