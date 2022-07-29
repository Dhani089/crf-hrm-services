package com.emp.employeeservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JwtTokenValidateFilter jwtTokenValidateFilter;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		/*httpSecurity
        .csrf().disable()
        .authorizeRequests()
          .antMatchers("/h2-ui").permitAll()
          .antMatchers("/api/**").authenticated()
          .anyRequest().authenticated()
        .and()
          .addFilterBefore(jwtTokenValidateFilter, UsernamePasswordAuthenticationFilter.class)
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
	    
		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtTokenValidateFilter, UsernamePasswordAuthenticationFilter.class);
		httpSecurity.cors();
	}
}
