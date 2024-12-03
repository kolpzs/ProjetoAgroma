package org.agroma.controllers.produto;

import org.agroma.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<ProdutoResponse> save(@RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(ProdutoMapper.toResponse(produtoService.save(ProdutoMapper.toEntityFromRequest(produtoRequest))));
    }

    @GetMapping("/findById")
    public ResponseEntity<ProdutoResponse> findById(@RequestParam Long id) {
        return ResponseEntity.ok(ProdutoMapper.toResponse(produtoService.findById(id)));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        return ResponseEntity.ok(produtoService.findAll().stream().map(ProdutoMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/update")
    public ResponseEntity<ProdutoResponse> update(@RequestBody ProdutoRequestExisting produtoRequest) {
        produtoService.update(ProdutoMapper.toEntityFromRequestExisting(produtoRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
