package com.example.demo_backend_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_backend_api.dto.PagamentoDTO;
import com.example.demo_backend_api.facade.PagamentoFacade;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoAPI {
	@Autowired private PagamentoFacade pagamentoFacade;

    @PostMapping("/aprovados")
    public String processar (@RequestBody PagamentoDTO request) {
        return pagamentoFacade.solicitarPagamento(request);
        
        		
    }
    
}