package br.com.fiap.farmacia.controllers;

import br.com.fiap.farmacia.dtos.produto.AtualizarProdutoDto;
import br.com.fiap.farmacia.dtos.produto.CadastroProdutoDto;
import br.com.fiap.farmacia.dtos.produto.DetalhesProdutoDto;
import br.com.fiap.farmacia.dtos.produto.ListagemProdutosDto;
import br.com.fiap.farmacia.models.Produto;
import br.com.fiap.farmacia.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> inserir(@RequestBody CadastroProdutoDto dto, UriComponentsBuilder uriBuilder) {
        Produto produto = new Produto(dto);
        repository.save(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesProdutoDto(produto));
    }

    @GetMapping
    public ResponseEntity<List<ListagemProdutosDto>> buscarTodos(Pageable pageable) {
        var produtos = repository.findAll(pageable).stream().map(ListagemProdutosDto::new).toList();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesProdutoDto> buscarPorId(@PathVariable("id") Long id) {
        var produto = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> atualizar(@RequestBody AtualizarProdutoDto dto, @PathVariable("id") Long id) {
        var produto = repository.getReferenceById(id);
        produto.atualizar(dto);

        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }
}
