package br.com.fiap.ecommerce.produto.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidosQueueSender {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue queue;
 
    public void send(String order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }
}
