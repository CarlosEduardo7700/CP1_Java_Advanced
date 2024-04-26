package br.com.fiap.farmacia.dtos.receitasMedicas;

import br.com.fiap.farmacia.models.ReceitaMedica;

import java.time.LocalDate;

public record ListagemReceitasMedicasDto(
        Long id,
        String usuario,
        LocalDate dataDeValidade,
        String medico,
        String medicamentos,
        String diagnostico,
        String notasAdicionais
) {
    public ListagemReceitasMedicasDto(ReceitaMedica receitaMedica) {
        this(
                receitaMedica.getId(),
                receitaMedica.getUsuario(),
                receitaMedica.getDataDeValidade(),
                receitaMedica.getMedico(),
                receitaMedica.getMedicamentos(),
                receitaMedica.getDiagnostico(),
                receitaMedica.getNotasAdicionais()
        );
    }
}
