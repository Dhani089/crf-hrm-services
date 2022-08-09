package com.emp.employeeservice.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenValidateFilter extends OncePerRequestFilter {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getServletPath();
		return !path.startsWith("/emp");

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
			final String requestTokenHeader = request.getHeader("Authorization");
			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				try {
					HttpHeaders headers = new HttpHeaders();
					// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
					headers.set("Authorization", requestTokenHeader);
					HttpEntity<String> entity = new HttpEntity<String>(headers);
					restTemplate.exchange("http://hrm-security-service/validatetoken", HttpMethod.GET, entity,
							String.class);
					filterChain.doFilter(request, response);
				} catch (Exception e) {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
					System.out.println("Unable to get JWT Token");
				}

		}
	}
}
