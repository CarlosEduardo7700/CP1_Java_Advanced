package br.com.fiap.farmacia.dtos.receitasMedicas;

import br.com.fiap.farmacia.models.ReceitaMedica;

import java.time.LocalDate;

public record DetalhesReceitaMedicaDto(
        Long id,
        String usuario,
        LocalDate dataDeEmissao,
        LocalDate dataDeValidade,
        String medico,
        String medicamentos,
        String diagnostico,
        String notasAdicionais
) {
    public DetalhesReceitaMedicaDto(ReceitaMedica receitaMedica) {
        this(
                receitaMedica.getId(),
                receitaMedica.getUsuario(),
                receitaMedica.getDataDeEmissao(),
                receitaMedica.getDataDeValidade(),
                receitaMedica.getMedico(),
                receitaMedica.getMedicamentos(),
                receitaMedica.getDiagnostico(),
                receitaMedica.getNotasAdicionais()
        );
    }
}
