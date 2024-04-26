package br.com.fiap.farmacia.dtos.endereco;

public record AtualizarEnderecoDto(
        String nome,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep,
        String pontoDeReferencia
) {
}
