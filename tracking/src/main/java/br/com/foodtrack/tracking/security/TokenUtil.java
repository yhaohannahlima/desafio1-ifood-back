package br.com.foodtrack.tracking.security;


import java.security.Key;
import java.util.Date;

import br.com.foodtrack.tracking.model.Entregador;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {
	
	private static final String HEADER        = "Authorization";  
	private static final String PREFIX        = "Bearer ";        
	private static final int    MINUTOS       = 0;
	private static final long   EXPIRATION    = 5*MINUTOS;    
	private static final String SECRET_KEY    = "3c0MMerc3Do1f00dP@r@T3st3sD3JWT*";
	private static final String EMISSOR       = "ProfIsidroIfood";
	
	
	public static String createToken(Entregador usuario) {
		
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		
		String token = Jwts.builder().setSubject(usuario.getNome(), usuario.getCodigoEntregador())
								     .setIssuer(EMISSOR)
								     .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
								     .signWith(secretKey, SignatureAlgorithm.HS256)
								     .compact();
		System.out.println("TOKEN gerado = "+token);
		return PREFIX + token;
	}
	
	/* posso criar métodos auxiliares para ajudar na validação */
	private static boolean isExpirationValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));	// a expiração para ser válida tem que ser após a data atual	
	}
	private static boolean isEmissorValid(String emissor) {
		return emissor.equals(EMISSOR);
	}
	private static boolean isSubjectValid(String username) {
		return username!=null && username.length() > 0;
	}
	
	public static Authentication validate(HttpServletRequest request) {
		// extrair o token do cabeçalho
		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, ""); // removi o prefixo "Bearer " do token
		// extrair as infos relevantes que eu quero do token
		
		Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes())
				                                    .build()
				                                    .parseClaimsJws(token);
		
		String username = jwsClaims.getBody().getSubject();
		String issuer   = jwsClaims.getBody().getIssuer();
		Date   expira   = jwsClaims.getBody().getExpiration();
		
		// se for válido, retorno um objeto do tipo Authentication
		if (isSubjectValid(username) && isEmissorValid(issuer) && isExpirationValid(expira)) {
			// eu preciso criar um objeto de Autenticação
			// o objeto é bem completo, onde podemos incluir o nível de autorização,
			// qual a lista de endpoints que o usuário pode acessar e assim por diante... 
			// nosso caso é mais simples.. pois não estamos tratando endpoints específicos para diferentes usuários
			return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
		}
	
		return null; 
	}
        
}
