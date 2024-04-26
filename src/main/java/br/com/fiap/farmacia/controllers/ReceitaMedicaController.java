package br.com.fiap.farmacia.controllers;

import br.com.fiap.farmacia.dtos.receitasMedicas.AtualizarReceitaMedicaDto;
import br.com.fiap.farmacia.dtos.receitasMedicas.CadastroReceitaMedicaDto;
import br.com.fiap.farmacia.dtos.receitasMedicas.DetalhesReceitaMedicaDto;
import br.com.fiap.farmacia.dtos.receitasMedicas.ListagemReceitasMedicasDto;
import br.com.fiap.farmacia.models.ReceitaMedica;
import br.com.fiap.farmacia.repositories.ReceitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("receitas-medicas")
public class ReceitaMedicaController {

    @Autowired
    private ReceitaMedicaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesReceitaMedicaDto> inserir(@RequestBody CadastroReceitaMedicaDto dto, UriComponentsBuilder uriBuilder) {
        ReceitaMedica receitaMedica = new ReceitaMedica(dto);
        repository.save(receitaMedica);

        URI uri = uriBuilder.path("/receitas-medicas/{id}").buildAndExpand(receitaMedica.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesReceitaMedicaDto(receitaMedica));
    }

    @GetMapping
    public ResponseEntity<List<ListagemReceitasMedicasDto>> buscarTodos(Pageable pageable) {
        var receitasMedicas = repository.findAll(pageable).stream().map(ListagemReceitasMedicasDto::new).toList();
        return ResponseEntity.ok(receitasMedicas);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesReceitaMedicaDto> buscarPorId(@PathVariable("id") Long id) {
        var receitaMedica = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesReceitaMedicaDto(receitaMedica));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesReceitaMedicaDto> atualizar(@RequestBody AtualizarReceitaMedicaDto dto, @PathVariable("id") Long id) {
        var receitaMedica = repository.getReferenceById(id);
        receitaMedica.atualizar(dto);

        return ResponseEntity.ok(new DetalhesReceitaMedicaDto(receitaMedica));
    }
}
