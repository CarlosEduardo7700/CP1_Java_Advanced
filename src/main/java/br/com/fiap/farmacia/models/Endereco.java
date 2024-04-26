package br.com.fiap.farmacia.models;

import br.com.fiap.farmacia.dtos.endereco.AtualizarEnderecoDto;
import br.com.fiap.farmacia.dtos.endereco.CadastroEnderecoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JACP1_ENDERECO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue
    @Column(name = "NR_ID")
    private Long id;

    @Column(name = "NM_ENDERECO", length = 100, nullable = false)
    private String nome;

    @Column(name = "NR_ENDERECO", length = 5, nullable = false)
    private String numero;

    @Column(name = "DS_COMPLEMENTO", length = 10)
    private String complemento;

    @Column(name = "NM_BAIRRO", length = 100, nullable = false)
    private String bairro;

    @Column(name = "NM_CIDADE", length = 100, nullable = false)
    private String cidade;

    @Column(name = "NM_ESTADO", length = 100, nullable = false)
    private String estado;

    @Column(name = "NR_CEP", length = 9, nullable = false)
    private String cep;

    @Column(name = "DS_PONTO_REFERENCIA", length = 150)
    private String pontoDeReferencia;

    public Endereco(CadastroEnderecoDto dto) {
        this.nome = dto.nome();
        this.numero = dto.numero();
        this.complemento = dto.complemento();
        this.bairro = dto.bairro();
        this.cidade = dto.cidade();
        this.estado = dto.estado();
        this.cep = dto.cep();
        this.pontoDeReferencia = dto.pontoDeReferencia();
    }

    public void atualizar(AtualizarEnderecoDto dto) {
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.numero() != null)
            this.numero = dto.numero();
        if (dto.complemento() != null)
            this.complemento = dto.complemento();
        if (dto.bairro() != null)
            this.bairro = dto.bairro();
        if (dto.cidade() != null)
            this.cidade = dto.cidade();
        if (dto.estado() != null)
            this.estado = dto.estado();
        if (dto.cep() != null)
            this.cep = dto.cep();
        if (dto.pontoDeReferencia() != null)
            this.pontoDeReferencia = dto.pontoDeReferencia();
    }
}
