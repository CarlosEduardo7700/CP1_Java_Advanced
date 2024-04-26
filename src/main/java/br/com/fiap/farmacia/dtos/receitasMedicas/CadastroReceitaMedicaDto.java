package br.com.fiap.farmacia.dtos.receitasMedicas;

import java.time.LocalDate;

public record CadastroReceitaMedicaDto(
        String usuario,
        LocalDate dataDeEmissao,
        LocalDate dataDeValidade,
        String medico,
        String medicamentos,
        String diagnostico,
        String notasAdicionais
) {
}
