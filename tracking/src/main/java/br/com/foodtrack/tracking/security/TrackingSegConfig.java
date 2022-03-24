package br.com.foodtrack.tracking.security;

import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class TrackingSegConfig extends WebSecurityConfigurerAdapter {
	
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers(HttpMethod.GET, "/pedidos/abertos*").permitAll()
		.antMatchers(HttpMethod.POST, "/pedidos/abertos*").permitAll()
		.antMatchers(HttpMethod.PUT, "/pedidos/abertos*").permitAll()
		.anyRequest().authenticated().and().cors();
		
		
	}

}
