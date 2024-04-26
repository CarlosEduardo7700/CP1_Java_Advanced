package br.com.fiap.farmacia.repositories;

import br.com.fiap.farmacia.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
