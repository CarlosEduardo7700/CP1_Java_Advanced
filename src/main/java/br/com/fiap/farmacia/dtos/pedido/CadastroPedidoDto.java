package br.com.fiap.farmacia.dtos.pedido;

import br.com.fiap.farmacia.models.enums.StatusPedido;

import java.math.BigDecimal;

public record CadastroPedidoDto(
        String cliente,
        String itensDoPedido,
        StatusPedido status,
        String enderecoDeEntrega,
        String metodoDePagamento,
        BigDecimal totalDoPedido
) {
}
