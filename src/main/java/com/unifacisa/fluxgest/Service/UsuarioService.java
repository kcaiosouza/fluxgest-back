package com.unifacisa.fluxgest.Service;

import com.unifacisa.fluxgest.Entity.Usuario;
import com.unifacisa.fluxgest.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(String id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = buscarPorId(id);
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setUsername(usuarioAtualizado.getUsername());
        usuarioExistente.setData_nascimento(usuarioAtualizado.getData_nascimento());
        usuarioExistente.setCargo(usuarioAtualizado.getCargo());
        usuarioExistente.setEmpresa_id(usuarioAtualizado.getEmpresa_id());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());
        return usuarioRepository.save(usuarioExistente);
    }

    public void deletar(String id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }
}
