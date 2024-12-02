package org.agroma.services;

import org.agroma.entities.PessoaEntity;
import org.agroma.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity findPessoaById(Long idPessoa) throws UserPrincipalNotFoundException {
        return pessoaRepository.findById(idPessoa).orElseThrow(
                ()-> new UserPrincipalNotFoundException("user not found")
        );
    }

    public List<PessoaEntity> findAllPessoa(){
        return pessoaRepository.findAll();
    }

    public PessoaEntity createPessoa(PessoaEntity pessoasEntity){
        pessoasEntity.setId(null);
        return pessoaRepository.save(
                pessoasEntity
        );
    }

    public void deletePessoa(Long idPessoa) throws UserPrincipalNotFoundException {
        try{
            pessoaRepository.deleteById(idPessoa);
        }catch (Exception e){
            throw new UserPrincipalNotFoundException("user not found");
        }
    }

    public void atualizarPessoa(PessoaEntity pessoasEntity){
        pessoaRepository.save(pessoasEntity);
    }

    private Boolean credentialMatch(PessoaEntity pessoasEntity, String login, String senha){
        return pessoasEntity.getDocumento().equalsIgnoreCase(login)
                && pessoasEntity.getSenha().equalsIgnoreCase(senha);
    }
}