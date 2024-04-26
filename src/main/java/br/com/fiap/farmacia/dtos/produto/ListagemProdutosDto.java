package br.com.fiap.farmacia.dtos.produto;

import br.com.fiap.farmacia.models.Produto;
import br.com.fiap.farmacia.models.enums.CategoriasDeProdutos;

import java.math.BigDecimal;

public record ListagemProdutosDto(
        Long id,
        String nome,
        BigDecimal preco,
        String fabricante,
        CategoriasDeProdutos categoria
) {
    public ListagemProdutosDto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getFabricante(),
                produto.getCategoria()
        );
    }
}
