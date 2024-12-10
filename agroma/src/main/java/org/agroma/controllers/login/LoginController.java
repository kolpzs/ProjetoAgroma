package org.agroma.controllers.login;

import org.agroma.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("login")
    public ResponseEntity<String> logar(@RequestBody LoginRequest login) {
        try {
            return ResponseEntity.ok(usuarioService.logar(login));
        } catch (AuthenticationException ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newUser/save")
    public ResponseEntity<HttpStatus> saveNewUser(@RequestParam String usuario, @RequestParam String password, @RequestParam Boolean isAdmin) {
        usuarioService.saveNewUser(usuario, password, isAdmin);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
