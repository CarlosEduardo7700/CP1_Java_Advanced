package br.com.fiap.farmacia.repositories;

import br.com.fiap.farmacia.models.ReceitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaMedicaRepository extends JpaRepository<ReceitaMedica, Long> {
}
