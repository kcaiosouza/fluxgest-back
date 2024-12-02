package com.unifacisa.fluxgest.Repository;

import com.unifacisa.fluxgest.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
