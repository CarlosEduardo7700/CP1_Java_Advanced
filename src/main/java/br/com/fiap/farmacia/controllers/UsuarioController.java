package br.com.fiap.farmacia.controllers;

import br.com.fiap.farmacia.dtos.usuario.AtualizarUsuarioDto;
import br.com.fiap.farmacia.dtos.usuario.CadastroUsuarioDto;
import br.com.fiap.farmacia.dtos.usuario.DetalhesUsuarioDto;
import br.com.fiap.farmacia.dtos.usuario.ListagemUsuariosDto;
import br.com.fiap.farmacia.models.Usuario;
import br.com.fiap.farmacia.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> inserir(@RequestBody CadastroUsuarioDto dto, UriComponentsBuilder uriBuilder) {
        Usuario usuario = new Usuario(dto);
        repository.save(usuario);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesUsuarioDto(usuario));
    }

    @GetMapping
    public ResponseEntity<List<ListagemUsuariosDto>> buscarTodos(Pageable pageable) {
        var usuarios = repository.findAll(pageable).stream().map(ListagemUsuariosDto::new).toList();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuarioDto> buscarPorId(@PathVariable("id") Long id) {
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> atualizar(@RequestBody AtualizarUsuarioDto dto, @PathVariable("id") Long id) {
        var usuario = repository.getReferenceById(id);
        usuario.atualizar(dto);

        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }
}
