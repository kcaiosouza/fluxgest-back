package com.unifacisa.fluxgest.Controller;

import com.unifacisa.fluxgest.Entity.Log;
import com.unifacisa.fluxgest.Service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<Log> listarTodos() {
        return logService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Log> buscarPorId(@PathVariable String id) {
        Log log = logService.buscarPorId(id);
        return ResponseEntity.ok(log);
    }

    @PostMapping
    public ResponseEntity<Log> criar(@RequestBody Log log) {
        Log novoLog = logService.criar(log);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Log> atualizar(@PathVariable String id, @RequestBody Log log) {
        Log logAtualizado = logService.atualizar(id, log);
        return ResponseEntity.ok(logAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        logService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
