package br.com.fiap.farmacia.dtos.usuario;

import br.com.fiap.farmacia.models.enums.Genero;
import br.com.fiap.farmacia.models.enums.TiposSanguineos;

import java.time.LocalDate;

public record CadastroUsuarioDto(
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
}
