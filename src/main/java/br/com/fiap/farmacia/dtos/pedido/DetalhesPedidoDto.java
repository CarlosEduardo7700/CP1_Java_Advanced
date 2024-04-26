package br.com.fiap.farmacia.dtos.pedido;

import br.com.fiap.farmacia.models.Pedido;
import br.com.fiap.farmacia.models.enums.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DetalhesPedidoDto(
        Long id,
        String cliente,
        LocalDateTime dataDoPedido,
        String itensDoPedido,
        StatusPedido status,
        String enderecoDeEntrega,
        String metodoDePagamento,
        BigDecimal totalDoPedido
) {
    public DetalhesPedidoDto(Pedido pedido) {
        this(
                pedido.getId(),
                pedido.getCliente(),
                pedido.getDataDoPedido(),
                pedido.getItensDoPedido(),
                pedido.getStatus(),
                pedido.getEnderecoDeEntrega(),
                pedido.getMetodoDePagamento(),
                pedido.getTotalDoPedido()
        );
    }
}
