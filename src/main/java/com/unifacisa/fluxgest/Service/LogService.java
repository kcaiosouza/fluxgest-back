package com.unifacisa.fluxgest.Service;

import com.unifacisa.fluxgest.Entity.Log;
import com.unifacisa.fluxgest.Repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> listarTodos() {
        return logRepository.findAll();
    }

    public Log buscarPorId(String id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log não encontrado com o ID: " + id));
    }

    public Log criar(Log log) {
        return logRepository.save(log);
    }

    public Log atualizar(String id, Log logAtualizado) {
        Log logExistente = buscarPorId(id);
        logExistente.setProduto_id(logAtualizado.getProduto_id());
        logExistente.setTipo(logAtualizado.getTipo());
        logExistente.setQuantidade(logAtualizado.getQuantidade());
        logExistente.setEmpresa_id(logAtualizado.getEmpresa_id());
        return logRepository.save(logExistente);
    }

    public void deletar(String id) {
        Log log = buscarPorId(id);
        logRepository.delete(log);
    }
}
