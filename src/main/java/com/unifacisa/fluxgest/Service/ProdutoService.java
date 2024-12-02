package com.unifacisa.fluxgest.Service;

import com.unifacisa.fluxgest.Entity.Produto;
import com.unifacisa.fluxgest.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(String id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(String id, Produto produtoAtualizado) {
        Produto produtoExistente = buscarPorId(id);
        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setPreco(produtoAtualizado.getPreco());
        produtoExistente.setCodigo_barras(produtoAtualizado.getCodigo_barras());
        produtoExistente.setQuantidade_estoque(produtoAtualizado.getQuantidade_estoque());
        produtoExistente.setEmpresa_id(produtoAtualizado.getEmpresa_id());
        return produtoRepository.save(produtoExistente);
    }

    public void deletar(String id) {
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
    }
}
