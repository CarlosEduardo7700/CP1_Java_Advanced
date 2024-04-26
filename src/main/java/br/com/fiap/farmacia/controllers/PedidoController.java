package br.com.fiap.farmacia.controllers;

import br.com.fiap.farmacia.dtos.pedido.AtualizarPedidoDto;
import br.com.fiap.farmacia.dtos.pedido.CadastroPedidoDto;
import br.com.fiap.farmacia.dtos.pedido.DetalhesPedidoDto;
import br.com.fiap.farmacia.dtos.pedido.ListagemPedidosDto;
import br.com.fiap.farmacia.models.Pedido;
import br.com.fiap.farmacia.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPedidoDto> inserir(@RequestBody CadastroPedidoDto dto, UriComponentsBuilder uriBuilder) {
        Pedido pedido = new Pedido(dto);
        repository.save(pedido);

        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesPedidoDto(pedido));
    }

    @GetMapping
    public ResponseEntity<List<ListagemPedidosDto>> buscarTodos(Pageable pageable) {
        var pedidos = repository.findAll(pageable).stream().map(ListagemPedidosDto::new).toList();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPedidoDto> buscarPorId(@PathVariable("id") Long id) {
        var pedido = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPedidoDto(pedido));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPedidoDto> atualizar(@RequestBody AtualizarPedidoDto dto, @PathVariable("id") Long id) {
        var pedido = repository.getReferenceById(id);
        pedido.atualizar(dto);

        return ResponseEntity.ok(new DetalhesPedidoDto(pedido));
    }
}
