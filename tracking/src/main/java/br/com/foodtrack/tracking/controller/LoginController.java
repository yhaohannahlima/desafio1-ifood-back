package br.com.foodtrack.tracking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity<?> logar(@RequestBody String email, String senha) {

		String emailFake = "entregador@entrega.com";
		String senhaFake = "1234";

		if (email.equals(emailFake) && senha.equals(senhaFake)) {
			return ResponseEntity.ok().build();
		}
        return ResponseEntity.status(401).build();
	}
}
