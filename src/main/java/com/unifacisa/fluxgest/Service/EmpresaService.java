package com.unifacisa.fluxgest.Service;

import com.unifacisa.fluxgest.Entity.Empresa;
import com.unifacisa.fluxgest.Repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    public Empresa buscarPorId(String id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada com o ID: " + id));
    }

    public Empresa criar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa atualizar(String id, Empresa empresaAtualizada) {
        Empresa empresaExistente = buscarPorId(id);
        empresaExistente.setNome(empresaAtualizada.getNome());
        empresaExistente.setCnpj(empresaAtualizada.getCnpj());
        empresaExistente.setEndereco(empresaAtualizada.getEndereco());
        empresaExistente.setSenha(empresaAtualizada.getSenha());
        return empresaRepository.save(empresaExistente);
    }

    public void deletar(String id) {
        Empresa empresa = buscarPorId(id);
        empresaRepository.delete(empresa);
    }
}
