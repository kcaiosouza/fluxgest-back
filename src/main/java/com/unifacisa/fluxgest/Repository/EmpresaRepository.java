package com.unifacisa.fluxgest.Repository;

import com.unifacisa.fluxgest.Entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
    Empresa findByCnpj(String cnpj);
}
