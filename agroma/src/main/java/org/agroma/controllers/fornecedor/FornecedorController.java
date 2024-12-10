package org.agroma.controllers.fornecedor;

import org.agroma.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fornecedor")
@CrossOrigin("*")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<FornecedorResponse> findById(@PathVariable("id") Long id) throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(FornecedorMapper.toResponse(fornecedorService.findById(id)));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<FornecedorResponse>> findAll() {
        return ResponseEntity.ok(fornecedorService.findAll().stream().map(FornecedorMapper::toResponse).collect(Collectors.toList()));
    }

    @PostMapping("/save")
    public ResponseEntity<FornecedorResponse> save(@RequestBody FornecedorRequest fornecedorRequest) {
        return ResponseEntity.ok(FornecedorMapper.toResponse(fornecedorService.save(FornecedorMapper.toEntityFromRequest(fornecedorRequest))));
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody FornecedorRequestExisting fornecedorRequest) {
        fornecedorService.update(FornecedorMapper.toEntityFromRequestExisting(fornecedorRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("delete/{idUser}")
    public ResponseEntity<HttpStatus> deleteFornecedor(@PathVariable(name = "idUser") Long id) {
        try {
            fornecedorService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
