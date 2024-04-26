package br.com.fiap.farmacia.models;

import br.com.fiap.farmacia.dtos.produto.AtualizarProdutoDto;
import br.com.fiap.farmacia.dtos.produto.CadastroProdutoDto;
import br.com.fiap.farmacia.models.enums.CategoriasDeProdutos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "JACP1_PRODUTO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue
    @Column(name = "NR_ID")
    private Long id;

    @Column(name = "NM_PRODUTO", length = 150, nullable = false)
    private String nome;

    @Column(name = "DS_PRODUTO", length = 400, nullable = false)
    private String descricao;

    @Column(name = "VL_PRECO", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "NR_QUANTIDADE_ESTOQUE", precision = 10, nullable = false)
    private Integer quantidadeEmEstoque;

    @Column(name = "NM_FABRICANTE", length = 100, nullable = false)
    private String fabricante;

    @Enumerated(EnumType.STRING)
    @Column(name = "DS_CATEGORIA", length = 30, nullable = false)
    private CategoriasDeProdutos categoria;

    public Produto(CadastroProdutoDto dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.preco = dto.preco();
        this.quantidadeEmEstoque = dto.quantidadeEmEstoque();
        this.fabricante = dto.fabricante();
        this.categoria = dto.categoria();
    }

    public void atualizar(AtualizarProdutoDto dto) {
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.descricao() != null)
            this.descricao = dto.descricao();
        if (dto.preco() != null)
            this.preco = dto.preco();
        if (dto.quantidadeEmEstoque() != null)
            this.quantidadeEmEstoque = dto.quantidadeEmEstoque();
        if (dto.fabricante() != null)
            this.fabricante = dto.fabricante();
        if (dto.categoria() != null)
            this.categoria = dto.categoria();
    }
}
