package br.com.fiap.farmacia.repositories;

import br.com.fiap.farmacia.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
