package com.emp.employeeservice.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmployeeUtils {

	@Autowired
	private RestTemplate restTemplate;
	
	
	public ResponseEntity<String> validateToken(HttpServletRequest request, HttpServletResponse response){
		final String requestTokenHeader = request.getHeader("Authorization");
		ResponseEntity<String> result = null;
			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				try {
					HttpHeaders headers = new HttpHeaders();
					// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
					headers.set("Authorization", requestTokenHeader);
					HttpEntity<String> entity = new HttpEntity<String>(headers);
				    result = restTemplate.exchange("http://hrm-security-service/validatetoken", HttpMethod.GET, entity,
							String.class);
				} catch (Exception e) {
					return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
				}
		
			} else {
				return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
				//logger.warn("JWT Token does not begin with Bearer String");
			}
			return result;
	}
	
}