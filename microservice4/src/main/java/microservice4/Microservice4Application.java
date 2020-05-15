package microservice4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Microservice4Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice4Application.class, args);
	}
}

@RestController
class Microservice4Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/*
	 * @GetMapping(value = "/microservice4") public String method4() {
	 * LOG.info("Inside method4"); return "Chain Call"; }
	 */
	
	
	@GetMapping(value = "/microservice4")
	public ResponseEntity<String> method4() {
		LOG.info("Inside method4");
		 HttpHeaders headers = new HttpHeaders();
		    headers.add("Custom-Header", "foo");
		return new ResponseEntity<>(
			      "Custom header set", headers, HttpStatus.OK);
	}
	
}