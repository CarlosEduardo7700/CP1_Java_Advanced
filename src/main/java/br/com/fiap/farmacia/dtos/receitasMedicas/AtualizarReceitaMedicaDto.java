package br.com.fiap.farmacia.dtos.receitasMedicas;

import java.time.LocalDate;

public record AtualizarReceitaMedicaDto(
        LocalDate dataDeEmissao,
        LocalDate dataDeValidade,
        String medicamentos,
        String diagnostico,
        String notasAdicionais
) {
}
