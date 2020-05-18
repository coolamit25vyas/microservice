package microservice2.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.boot.web.servlet.error.ErrorController;*/
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
class Microservice2Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;

	
	  @Autowired Tracer tracer;
	 
	 
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@GetMapping(value = "/microservice2")
	public ResponseEntity<String> method2(@RequestHeader Map<String, String> headers) {
		LOG.info("Inside method2" + headers.toString());
		String baseUrl = "http://localhost:8082/microservice3";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		LOG.info("The response received by method2 is " + response);
		return new ResponseEntity<String>("chain call", HttpStatus.ACCEPTED);
	}
}