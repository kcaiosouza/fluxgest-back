package com.unifacisa.fluxgest.Repository;

import com.unifacisa.fluxgest.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByUsername(String username);
}
