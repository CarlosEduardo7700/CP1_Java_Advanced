package br.com.fiap.farmacia.repositories;

import br.com.fiap.farmacia.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
