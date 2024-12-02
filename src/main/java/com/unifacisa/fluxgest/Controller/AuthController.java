package com.unifacisa.fluxgest.Controller;

import com.unifacisa.fluxgest.Entity.Empresa;
import com.unifacisa.fluxgest.Entity.Usuario;
import com.unifacisa.fluxgest.Repository.EmpresaRepository;
import com.unifacisa.fluxgest.Repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;

    public AuthController(UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest.getUsername() != null && loginRequest.getSenha() != null) {
            Usuario usuarioExistente = usuarioRepository.findByUsername(loginRequest.getUsername());
            if (usuarioExistente != null && usuarioExistente.getSenha().equals(loginRequest.getSenha())) {
                return ResponseEntity.ok("Login bem-sucedido (Usuário)!");
            }
        }

        if (loginRequest.getCnpj() != null && loginRequest.getSenha() != null) {
            Empresa empresaExistente = empresaRepository.findByCnpj(loginRequest.getCnpj());
            if (empresaExistente != null && empresaExistente.getSenha().equals(loginRequest.getSenha())) {
                return ResponseEntity.ok("Login bem-sucedido (Empresa)!");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }

    public static class LoginRequest {
        private String username;
        private String cnpj;
        private String senha;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }
}
