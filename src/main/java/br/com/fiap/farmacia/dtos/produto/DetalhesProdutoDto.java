package br.com.fiap.farmacia.dtos.produto;

import br.com.fiap.farmacia.models.Produto;
import br.com.fiap.farmacia.models.enums.CategoriasDeProdutos;

import java.math.BigDecimal;

public record DetalhesProdutoDto(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidadeEmEstoque,
        String fabricante,
        CategoriasDeProdutos categoria
) {
    public DetalhesProdutoDto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidadeEmEstoque(),
                produto.getFabricante(),
                produto.getCategoria()
        );
    }
}
