package microservice1;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/*
import brave.Tracer;*/

@SpringBootApplication
public class Microservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}
}

@RestController
class Microservice1Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/*
	 * @Autowired Tracer tracer;
	 */

	@GetMapping(value = "/microservice1")
	public ResponseEntity<Map<String,String>> method1(@RequestHeader MultiValueMap<String, String> headers) {
		LOG.info("Inside method1" + headers.toString());
		String baseUrl = "http://localhost:8081/microservice2";
		
		HttpHeaders hd = new HttpHeaders();
		hd.addAll(headers);    
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, requestEntity, String.class).getBody();
		LOG.info("The response received by method1 is " + response);
		return new ResponseEntity<Map<String,String>>(headers, HttpStatus.ACCEPTED);
	}
}