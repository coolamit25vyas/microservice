/*
 * package microservice2;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.SpringApplication; import
 * org.springframework.boot.autoconfigure.SpringBootApplication; import
 * org.springframework.cloud.sleuth.annotation.ContinueSpan; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestHeader; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.client.RestTemplate; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc;
 * 
 * @SpringBootApplication
 * 
 * @EnableWebMvc
 * 
 * public class Microservice2Application {
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(Microservice2Application.class, args); } }
 * 
 * @RestController class Microservice2Controller {
 * 
 * private final Logger LOG = LoggerFactory.getLogger(this.getClass());
 * 
 * @Autowired RestTemplate restTemplate;
 * 
 * 
 * @Autowired private Tracer tracer;
 * 
 * @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
 * 
 * @GetMapping(value = "/microservice2") public String method2() {
 * LOG.info("Inside method2"); String baseUrl =
 * "http://localhost:8082/microservice3"; String response = (String)
 * restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
 * LOG.info("The response received by method2 is " + response); return response;
 * }
 * 
 * @GetMapping(value = "/microservice2") // @ContinueSpan public String
 * custom(@RequestHeader ("request-id") String requestId) {
 * LOG.info("Inside method2"); System.out.println(requestId);
 * 
 * 
 * Span span = tracer.createSpan("CorrelationalId");
 * span.tag("CorrelationalId",requestId );
 * 
 * 
 * String baseUrl = "http://localhost:8082/microservice3"; String response =
 * (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null,
 * String.class).getBody(); LOG.info("The response received by method2 is " +
 * response); tracer.close(span); return response; }
 * 
 * }
 */


package microservice2;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Microservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}
}

@RestController
class Microservice2Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@GetMapping(value = "/microservice2")
	/*
	 * public String method2(@RequestHeader(name = "ID",required=false) String Id )
	 */
	public  ResponseEntity<String> method2(@RequestHeader(name = "id",required=false) String Id,@RequestHeader HttpHeaders headers)
	{
		
		headers.get("correlation-id");
		System.out.println("Id is:"+Id);
		System.out.println("correlation-id is:"+headers.get("correlation-id"));
		LOG.info("Inside method2");
		
		  String baseUrl = "http://localhost:8082/microservice3"; String response =
		  (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null,
		  String.class).getBody(); LOG.info("The response received by method2 is " +
		  response);
		 
		return new ResponseEntity<String>("chain call",HttpStatus.ACCEPTED);
	}
}
