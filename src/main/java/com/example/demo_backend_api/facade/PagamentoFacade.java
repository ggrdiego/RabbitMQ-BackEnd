package com.example.demo_backend_api.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_backend_api.dto.PagamentoDTO;
import com.example.demo_backend_api.producer.PagamentoRequestProdutor;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class PagamentoFacade {
    @Autowired private PagamentoRequestProdutor producer;

    public String solicitarPagamento (PagamentoDTO pagamento) {
       
    	try {
            producer.integrarPagamento(pagamento);
        } catch (JsonProcessingException e) {
            return "Erro ao processar pagamento" + e.getMessage();
        }
       
        return "Seu pagamento está sendo processado...";
    }

	public void errorPagamento(String payload) {
		System.err.println("==========RESPOSTA ERRO===========" + payload);	
	}

	public void sucessoPagamento(String payload) {
		System.out.println("==========RESPOSTA SUCESSO===========" + payload);
		// TODO Auto-generated method stub
		
	}
}
