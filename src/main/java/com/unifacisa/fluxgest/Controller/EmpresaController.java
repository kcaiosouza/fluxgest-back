package com.unifacisa.fluxgest.Controller;

import com.unifacisa.fluxgest.Entity.Empresa;
import com.unifacisa.fluxgest.Service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> listarTodas() {
        return empresaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable String id) {
        Empresa empresa = empresaService.buscarPorId(id);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping
    public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = empresaService.criar(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable String id, @RequestBody Empresa empresa) {
        Empresa empresaAtualizada = empresaService.atualizar(id, empresa);
        return ResponseEntity.ok(empresaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        empresaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
