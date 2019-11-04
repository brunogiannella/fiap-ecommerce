package br.com.fiap.ecommerce.produto.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por inserir informações na fila PEDIDOS do Rabbit MQ
 * Producer
 * @author Bruno Giannella
 *
 */
@Component
public class PedidosQueueSender {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue queue;
 
    /**
     * Método responsável por inserir informações me texto na fila PEDIDOS do RabbitMQ
     * @param order - String a ser inserida na fila como mensagem
     */
    public void send(String order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }
}
