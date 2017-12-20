package br.com.systemjmrs.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll();
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/3.10.0/**");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("Professor").password("123").roles("PROFESSOR");
		builder.inMemoryAuthentication().withUser("Coordenador").password("123").roles("COORDENADOR");
	}
	
	

}
