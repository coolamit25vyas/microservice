package microservice2.config;

import org.springframework.cloud.sleuth.SpanExtractor;
import org.springframework.cloud.sleuth.SpanInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import microservice2.SpanExtractor.CustomHttpServletRequestSpanExtractor;
import microservice2.SpanExtractor.CustomHttpServletResponseSpanInjector;

@Configuration
public class EchoConfig {
	@Bean
	@Primary
	SpanExtractor<HttpServletRequest> customHttpServletRequestSpanExtractor() {
	    return new CustomHttpServletRequestSpanExtractor();
	}
	
	@Bean
	@Primary
	SpanInjector<HttpServletResponse> customHttpServletResponseSpanInjector() {
		return new CustomHttpServletResponseSpanInjector();
	}
	
}