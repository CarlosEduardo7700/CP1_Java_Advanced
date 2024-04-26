package br.com.fiap.farmacia.dtos.endereco;

import br.com.fiap.farmacia.models.Endereco;

public record ListagemEnderecosDto(
        Long id,
        String nome,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
    public ListagemEnderecosDto(Endereco endereco) {
        this(
                endereco.getId(),
                endereco.getNome(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep()
        );
    }
}
