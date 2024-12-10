package org.agroma.services;

import org.agroma.controllers.login.LoginRequest;
import org.agroma.entities.UsuarioEntity;
import org.agroma.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtils jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;


    public String logar(LoginRequest login) {
        System.out.println(login.toString());
        var data = usuarioRepository.findByUsername(login.nome()).orElseThrow();
        System.out.println(data.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.nome(),
                        login.senha()
                )
        );
        UsuarioEntity user = usuarioRepository.findByUsername(login.nome()).orElseThrow();

        return jwtService.generateToken(user);
    }

    public void saveNewUser(String usuario, String password, Boolean isAdmin) {
        usuarioRepository.save(
                new UsuarioEntity(
                        null,
                        usuario,
                        passwordEncoder.encode(password),
                        (isAdmin?"admin":"user")
                )
        );
    }
}
