package br.com.foodtrack.tracking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.DTO.EntregadorDTO;
import br.com.foodtrack.tracking.DTO.EntregadorLoginDTO;

@RestController
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity<?> logar(@RequestBody EntregadorLoginDTO login) {	
		
		String emailFake = "entregador@entrega.com";
		String senhaFake = "1234";

		if (login.getEmail().equals(emailFake) && login.getSenha().equals(senhaFake)) {
			return ResponseEntity.ok().build();
		}
        return ResponseEntity.status(401).body("msg: Acesso negado!");
	}
}
