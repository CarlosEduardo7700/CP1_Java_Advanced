package br.com.fiap.farmacia.dtos.usuario;

import br.com.fiap.farmacia.models.Usuario;
import br.com.fiap.farmacia.models.enums.Genero;
import br.com.fiap.farmacia.models.enums.TiposSanguineos;

import java.time.LocalDate;

public record DetalhesUsuarioDto(
        Long id,
        String nome,
        String cpf,
        Genero genero,
        LocalDate dataDeNascimento,
        String email,
        String telefone,
        String senha,
        TiposSanguineos tipoSanguineo,
        String alergias
) {
    public DetalhesUsuarioDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getGenero(),
                usuario.getDataDeNascimento(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getSenha(),
                usuario.getTipoSanguineo(),
                usuario.getAlergias()
        );
    }
}
