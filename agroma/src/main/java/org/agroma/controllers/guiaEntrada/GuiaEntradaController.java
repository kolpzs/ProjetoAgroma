package org.agroma.controllers.guiaEntrada;

import org.agroma.services.GuiaEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guiaentrada")
@CrossOrigin("*")
public class GuiaEntradaController {

    @Autowired
    private GuiaEntradaService guiaEntradaService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<GuiaEntradaResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(GuiaEntradaMapper.toResponse(guiaEntradaService.findById(id)));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<GuiaEntradaResponse>> findAll() {
        return ResponseEntity.ok(guiaEntradaService.findAll().stream().map(GuiaEntradaMapper::toResponse).collect(Collectors.toList()));
    }

    @PostMapping("/save")
    public ResponseEntity<GuiaEntradaResponse> save(@RequestBody GuiaEntradaRequest guiaEntradaRequest) {
        return ResponseEntity.ok(GuiaEntradaMapper.toResponse(guiaEntradaService.save(GuiaEntradaMapper.toEntityFromRequest(guiaEntradaRequest))));
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody GuiaEntradaRequestExisting guiaEntradaRequest) {
        guiaEntradaService.update(GuiaEntradaMapper.toEntityFromRequestExisting(guiaEntradaRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
