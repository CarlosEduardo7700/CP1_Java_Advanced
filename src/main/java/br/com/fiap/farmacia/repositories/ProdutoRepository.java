package br.com.fiap.farmacia.repositories;

import br.com.fiap.farmacia.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
