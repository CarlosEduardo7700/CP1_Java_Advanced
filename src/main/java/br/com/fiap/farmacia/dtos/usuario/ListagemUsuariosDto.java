package br.com.fiap.farmacia.dtos.usuario;

import br.com.fiap.farmacia.models.Usuario;
import br.com.fiap.farmacia.models.enums.Genero;
import org.springframework.data.domain.Page;

public record ListagemUsuariosDto(
        Long id,
        String nome,
        String cpf,
        Genero genero,
        String email,
        String telefone
) {
    public ListagemUsuariosDto(Usuario usuarios) {
        this(
                usuarios.getId(),
                usuarios.getNome(),
                usuarios.getCpf(),
                usuarios.getGenero(),
                usuarios.getEmail(),
                usuarios.getTelefone()
        );
    }
}
