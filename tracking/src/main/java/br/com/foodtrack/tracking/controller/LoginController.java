package br.com.foodtrack.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.DTO.EntregadorLoginDTO;
import br.com.foodtrack.tracking.security.Token;
import br.com.foodtrack.tracking.services.IEntregadorLoginService;

@RestController
@CrossOrigin("*")
public class LoginController {
    
    @Autowired
	private IEntregadorLoginService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> acessar(@RequestBody EntregadorLoginDTO dadosAcesso){
		Token token;
		try {
			token = service.gerarAcessoEntregador(dadosAcesso);
			if (token != null) {
				return ResponseEntity.ok(token);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(400).body(e.getMessage());
		}
		
	   return ResponseEntity.status(400).body("Usuário Inválido!");
	}
   

}
