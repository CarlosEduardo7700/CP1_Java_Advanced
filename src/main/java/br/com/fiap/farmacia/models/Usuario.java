package br.com.fiap.farmacia.models;

import br.com.fiap.farmacia.dtos.usuario.AtualizarUsuarioDto;
import br.com.fiap.farmacia.dtos.usuario.CadastroUsuarioDto;
import br.com.fiap.farmacia.models.enums.Genero;
import br.com.fiap.farmacia.models.enums.TiposSanguineos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "JACP1_USUARIO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "NR_ID")
    private Long id;

    @Column(name = "NM_USUARIO", length = 100, nullable = false)
    private String nome;

    @Column(name = "NR_CPF", length = 11, nullable = false, unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "DS_GENERO", length = 30, nullable = false)
    private Genero genero;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private LocalDate dataDeNascimento;

    @Column(name = "DS_EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "NR_TELEFONE", length = 15, nullable = false)
    private String telefone;

    @Column(name = "DS_SENHA", length = 50, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_SANGUINEO", length = 15, nullable = false)
    private TiposSanguineos tipoSanguineo;

    @Column(name = "DS_ALERGIAS", length = 200, nullable = false)
    private String alergias;

    public Usuario(CadastroUsuarioDto dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.genero = dto.genero();
        this.dataDeNascimento = dto.dataDeNascimento();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.senha = dto.senha();
        this.tipoSanguineo = dto.tipoSanguineo();
        this.alergias = dto.alergias();
    }

    public void atualizar(AtualizarUsuarioDto dto) {
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.genero() != null)
            this.genero = dto.genero();
        if (dto.dataDeNascimento() != null)
            this.dataDeNascimento = dto.dataDeNascimento();
        if (dto.email() != null)
            this.email = dto.email();
        if (dto.telefone() != null)
            this.telefone = dto.telefone();
        if (dto.senha() != null)
            this.senha = dto.senha();
        if (dto.alergias() != null)
            this.alergias = dto.alergias();
    }
}
