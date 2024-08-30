package com.example.demo_backend_api.consumer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

import com.example.demo_backend_api.facade.PagamentoFacade;

public class PagamentoREsponseErrorConsumidor {

	@Autowired private PagamentoFacade pagamentoFacade;
	
	
	@RabbitListener(queues = {"pagamento-response-erro-queue"})
	public void receive(@Payload Message<String> message) {
		System.out.println("Message" + message.toString()+ LocalDateTime.now());
		String payload = String.valueOf(message.getPayload());
		
		pagamentoFacade.errorPagamento(payload);
		
		
	}
	


}
