package com.baozistore.service;

import com.baozistore.exception.ResourceNotFoundException;
import com.baozistore.model.Cliente;
import com.baozistore.model.Pedido;
import com.baozistore.model.Produto;
import com.baozistore.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService, ProdutoService produtoService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public Pedido criar(Long clienteId, Long produtoId, Integer quantidade) {
        // Primeiro valida os dados que vieram do pedido.
        Cliente cliente = clienteService.buscarPorId(clienteId);
        Produto produto = produtoService.buscarPorId(produtoId);

        // Monta o pedido com cliente, produto e quantidade.
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(quantidade);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido nao encontrado: " + id));
    }

    public Pedido atualizar(Long id, Long clienteId, Long produtoId, Integer quantidade) {
        Pedido pedido = buscarPorId(id);
        pedido.setCliente(clienteService.buscarPorId(clienteId));
        pedido.setProduto(produtoService.buscarPorId(produtoId));
        pedido.setQuantidade(quantidade);
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        Pedido pedido = buscarPorId(id);
        pedidoRepository.delete(pedido);
    }
}
