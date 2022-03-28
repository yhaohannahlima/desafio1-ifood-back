package br.com.foodtrack.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.DTO.RastreamentoDTO;
import br.com.foodtrack.tracking.Dao.RastreamentoDao;
import br.com.foodtrack.tracking.model.Rastreamento;
import br.com.foodtrack.tracking.services.IRastreamentoService;


@RestController
@CrossOrigin("*")
public class RastreamentoController {

	@Autowired
	private IRastreamentoService service;
	
	
	@PostMapping("/rastreamento")
	public ResponseEntity<?> inserirRota(@RequestBody RastreamentoDTO rota){
		
		RastreamentoDTO resultado = service.adicionarRota(rota);
		
		if(resultado != null) {
			
			return ResponseEntity.status(201).build();
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	

	
}
