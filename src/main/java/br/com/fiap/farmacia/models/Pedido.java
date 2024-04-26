package br.com.fiap.farmacia.models;

import br.com.fiap.farmacia.dtos.pedido.AtualizarPedidoDto;
import br.com.fiap.farmacia.dtos.pedido.CadastroPedidoDto;
import br.com.fiap.farmacia.models.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "JACP1_PEDIDO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Pedido {

    @Id
    @GeneratedValue
    @Column(name = "NR_ID")
    private Long id;

    @Column(name = "NM_CLIENTE", length = 100, nullable = false)
    private String cliente;

    @CreatedDate
    @Column(name = "DT_PEDIDO", nullable = false)
    private LocalDateTime dataDoPedido;

    @Column(name = "DS_ITENS_PEDIDO", length = 400, nullable = false)
    private String itensDoPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "ST_PEDIDO", length = 20, nullable = false)
    private StatusPedido status;

    @Column(name = "DS_ENDERECO_ENTREGA", length = 200, nullable = false)
    private String enderecoDeEntrega;

    @Column(name = "NM_METODO_PAGAMENTO", length = 100, nullable = false)
    private String metodoDePagamento;

    @Column(name = "VL_TOTAL_PEDIDO", precision = 15, scale = 2, nullable = false)
    private BigDecimal totalDoPedido;

    public Pedido(CadastroPedidoDto dto) {
        this.cliente = dto.cliente();
        this.itensDoPedido = dto.itensDoPedido();
        this.status = dto.status();
        this.enderecoDeEntrega = dto.enderecoDeEntrega();
        this.metodoDePagamento = dto.metodoDePagamento();
        this.totalDoPedido = dto.totalDoPedido();
    }

    public void atualizar(AtualizarPedidoDto dto) {
        if (dto.cliente() != null)
            this.cliente = dto.cliente();
        if (dto.itensDoPedido() != null)
            this.itensDoPedido = dto.itensDoPedido();
        if (dto.status() != null)
            this.status = dto.status();
        if (dto.enderecoDeEntrega() != null)
            this.enderecoDeEntrega = dto.enderecoDeEntrega();
        if (dto.metodoDePagamento() != null)
            this.metodoDePagamento = dto.metodoDePagamento();
        if (dto.totalDoPedido() != null)
            this.totalDoPedido = dto.totalDoPedido();
    }
}
