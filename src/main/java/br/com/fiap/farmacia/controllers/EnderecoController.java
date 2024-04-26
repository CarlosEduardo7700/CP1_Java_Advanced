package br.com.fiap.farmacia.controllers;

import br.com.fiap.farmacia.dtos.endereco.AtualizarEnderecoDto;
import br.com.fiap.farmacia.dtos.endereco.CadastroEnderecoDto;
import br.com.fiap.farmacia.dtos.endereco.DetalhesEnderecoDto;
import br.com.fiap.farmacia.dtos.endereco.ListagemEnderecosDto;
import br.com.fiap.farmacia.models.Endereco;
import br.com.fiap.farmacia.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEnderecoDto> inserir(@RequestBody CadastroEnderecoDto dto, UriComponentsBuilder uriBuilder) {
        Endereco endereco = new Endereco(dto);
        repository.save(endereco);

        URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesEnderecoDto(endereco));
    }

    @GetMapping
    public ResponseEntity<List<ListagemEnderecosDto>> buscarTodos(Pageable pageable) {
        var enderecos = repository.findAll(pageable).stream().map(ListagemEnderecosDto::new).toList();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesEnderecoDto> buscarPorId(@PathVariable("id") Long id) {
        var endereco = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEnderecoDto(endereco));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesEnderecoDto> atualizar(@RequestBody AtualizarEnderecoDto dto, @PathVariable("id") Long id) {
        var endereco = repository.getReferenceById(id);
        endereco.atualizar(dto);

        return ResponseEntity.ok(new DetalhesEnderecoDto(endereco));
    }
}
