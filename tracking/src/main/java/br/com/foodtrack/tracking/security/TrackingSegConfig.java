package br.com.foodtrack.tracking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class TrackingSegConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private TrackingEntryPoint entryPoint;
	
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.exceptionHandling().authenticationEntryPoint(entryPoint)
		.and()
		.authorizeHttpRequests()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers(HttpMethod.GET, "/pedidos*").permitAll()
		.antMatchers(HttpMethod.GET, "/pedidos/abertos*").permitAll()
//		.antMatchers(HttpMethod.PUT, "/pedidos/aceitar/*").permitAll()
//		.antMatchers(HttpMethod.PUT, "/pedidos/finalizar/*").permitAll()
//		.antMatchers(HttpMethod.PUT, "/pedidos/cancelar/*").permitAll()
		.antMatchers(HttpMethod.GET, "/entregadores*").permitAll()
		.antMatchers(HttpMethod.POST, "/rastreamento*").permitAll()
		.anyRequest().authenticated().and().cors();
		
		//criar filtro para tratar req.
		http.addFilterBefore(new TrackingReqFiltre(), UsernamePasswordAuthenticationFilter.class);
	}

}
