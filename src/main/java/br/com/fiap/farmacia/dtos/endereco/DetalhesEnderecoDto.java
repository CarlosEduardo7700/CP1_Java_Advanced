package br.com.fiap.farmacia.dtos.endereco;

import br.com.fiap.farmacia.models.Endereco;

public record DetalhesEnderecoDto(
        Long id,
        String nome,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep,
        String pontoDeReferencia
) {
    public DetalhesEnderecoDto(Endereco endereco) {
        this(
                endereco.getId(),
                endereco.getNome(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getPontoDeReferencia()
        );
    }
}
