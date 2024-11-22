package org.agroma.controllers.pessoa;

import org.agroma.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin("*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable("id") Long idPessoa) throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(
                PessoaMapper.toResponse(pessoaService.findPessoaById(idPessoa))
        );
    }

    @GetMapping("/findall")
    public ResponseEntity<List<PessoaResponse>> findAll(){
        return ResponseEntity.ok(
                pessoaService.findAllPessoa().stream().map(PessoaMapper::toResponse)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/save")
    public ResponseEntity<PessoaResponse> save(@RequestBody PessoaRequest pessoaRequest){
        return ResponseEntity.ok(
                PessoaMapper.toResponse(
                        pessoaService.createPessoa(
                                PessoaMapper.toEntityFromRequest(pessoaRequest)
                        )
                )
        );
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody PessoaRequestExisting pessoaRequest){
        pessoaService.atualizarPessoa(
                PessoaMapper.toEntityFromRequestExisting(pessoaRequest));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("delete/{idUser}")
    public ResponseEntity<HttpStatus> deletePessoa(@PathVariable (name = "idUser") Long id){
        try{
            pessoaService.deletePessoa(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
