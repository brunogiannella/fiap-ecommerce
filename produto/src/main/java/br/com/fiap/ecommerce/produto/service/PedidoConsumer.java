package br.com.fiap.ecommerce.produto.service;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.ecommerce.produto.model.ItemCarrinho;
import br.com.fiap.ecommerce.produto.model.Pedido;
import br.com.fiap.ecommerce.produto.model.Produto;

@Component
public class PedidoConsumer {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RabbitListener(queues = { "${queue.order.name}" })
	public void receive(@Payload String fileBody) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Pedido pedido = mapper.readValue(fileBody, Pedido.class);
			
			if(pedido != null && pedido.getCarrinho() != null && pedido.getCarrinho().getItensCarrinho() != null) {
				for(ItemCarrinho item : pedido.getCarrinho().getItensCarrinho()) {
					Produto produto = produtoService.getProduto(item.getIdProduto());
					produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidadeProduto());
					produtoService.update(produto);
				}
			}
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
