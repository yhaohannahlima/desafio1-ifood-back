package br.com.foodtrack.tracking.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.foodtrack.tracking.model.Entregador;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {
	
	private static final String HEADER        = "Authorization";  
	private static final String PREFIX        = "Bearer ";        
	private static final int    MINUTOS       = 60000;
	private static final long   EXPIRATION    = 60 * MINUTOS;	
	private static final String SECRET_KEY    = "73s731foodP@r@T3st3D3JWTd07r@c3B";	
	private static final String EMISSOR       = "Traceback";
	
	
	
	public static String createToken(Entregador usuario) {
		String id = Integer.toString(usuario.getCodigoEntregador());
		
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		
		String token = Jwts.builder().setSubject(id)									
								     .setIssuer(EMISSOR)
								     .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
								     .signWith(secretKey, SignatureAlgorithm.HS256)
								     .compact();
		return PREFIX + token;
	}
	
	private static boolean isExpirationValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));	
	}
	private static boolean isEmissorValid(String emissor) {
		return emissor.equals(EMISSOR);
	}
	private static boolean isSubjectValid(String nome) {
		return nome !=null && nome.length() > 0;
	}
	
	public static Authentication validate(HttpServletRequest request) {
		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, ""); 
		
		Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes())
				                                    .build()
				                                    .parseClaimsJws(token);
		
		String nome     = jwsClaims.getBody().getSubject();
		String issuer   = jwsClaims.getBody().getIssuer();
		Date   expira   = jwsClaims.getBody().getExpiration();
		
		if (isSubjectValid(nome) && isEmissorValid(issuer) && isExpirationValid(expira)) {
		
			return new UsernamePasswordAuthenticationToken(nome, null, Collections.emptyList());
		}
	
		return null; 
	}
        
}
