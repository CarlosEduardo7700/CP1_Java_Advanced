package br.com.fiap.farmacia.dtos.produto;

import br.com.fiap.farmacia.models.enums.CategoriasDeProdutos;

import java.math.BigDecimal;

public record AtualizarProdutoDto(
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidadeEmEstoque,
        String fabricante,
        CategoriasDeProdutos categoria
) {
}
