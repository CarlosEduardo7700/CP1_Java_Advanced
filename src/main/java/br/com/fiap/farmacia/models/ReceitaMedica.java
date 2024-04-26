package br.com.fiap.farmacia.models;

import br.com.fiap.farmacia.dtos.receitasMedicas.AtualizarReceitaMedicaDto;
import br.com.fiap.farmacia.dtos.receitasMedicas.CadastroReceitaMedicaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "JACP1_RECEITA_MEDICA")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ReceitaMedica {

    @Id
    @GeneratedValue
    @Column(name = "NR_ID")
    private Long id;

    @Column(name = "NM_USUARIO", length = 100, nullable = false)
    private String usuario;

    @Column(name = "DT_EMISSAO", nullable = false)
    private LocalDate dataDeEmissao;

    @Column(name = "DT_VALIDADE", nullable = false)
    private LocalDate dataDeValidade;

    @Column(name = "NM_MEDICO", length = 100, nullable = false)
    private String medico;

    @Column(name = "DS_MEDICAMENTOS", length = 400, nullable = false)
    private String medicamentos;

    @Column(name = "DS_DIAGNOSTICO", length = 500, nullable = false)
    private String diagnostico;

    @Column(name = "DS_NOTAS_ADICIONAIS", length = 300)
    private String notasAdicionais;

    public ReceitaMedica(CadastroReceitaMedicaDto dto) {
        this.usuario = dto.usuario();
        this.dataDeEmissao = dto.dataDeEmissao();
        this.dataDeValidade = dto.dataDeValidade();
        this.medico = dto.medico();
        this.medicamentos = dto.medicamentos();
        this.diagnostico = dto.diagnostico();
        this.notasAdicionais = dto.notasAdicionais();
    }

    public void atualizar(AtualizarReceitaMedicaDto dto) {
        if (dto.dataDeEmissao() != null)
            this.dataDeEmissao = dto.dataDeEmissao();
        if (dto.dataDeValidade() != null)
            this.dataDeValidade = dto.dataDeValidade();
        if (dto.medicamentos() != null)
            this.medicamentos = dto.medicamentos();
        if (dto.diagnostico() != null)
            this.diagnostico = dto.diagnostico();
        if (dto.notasAdicionais() != null)
            this.notasAdicionais = dto.notasAdicionais();
    }
}
