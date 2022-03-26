package br.com.foodtrack.tracking.security;


import java.security.Key;

import br.com.foodtrack.tracking.model.Entregador;

public class TokenUtil {
	
	private static final String  HEADER     = "Authorization";
	private static final String  PREFIX     = "Bearer";
	private static final int     MINUTOS    = 0;
	private static final long    EXPIRATION = 5*MINUTOS;
	private static final String  SECRET_KEY = "73s731foodP@r@T3st3D3JWTd07r@c3B";
	private static final String  EMISSOR    = "Traceback";

	public static String createToken(Entregador usuario) {
		
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		
		String token = Jwts.builder().setSubject(usuario.getNome(), usuario.getCodigoEntregador());
		
		return null;
	}
        
}
