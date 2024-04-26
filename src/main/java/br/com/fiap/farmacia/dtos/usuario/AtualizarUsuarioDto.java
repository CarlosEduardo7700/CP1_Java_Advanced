package br.com.fiap.farmacia.dtos.usuario;

import br.com.fiap.farmacia.models.enums.Genero;

import java.time.LocalDate;

public record AtualizarUsuarioDto(
        String nome,
        Genero genero,
        LocalDate dataDeNascimento,
        String email,
        String telefone,
        String senha,
        String alergias
) {
}
