package microservice2.SpanExtractor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.springframework.cloud.sleuth.instrument.web.HttpSpanExtractor;*/
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanExtractor;


/*
@Component*/
public class CustomHttpServletRequestSpanExtractor implements SpanExtractor<HttpServletRequest>

{
	//private static final Logger LOGGER = LoggerFactory.getLogger(CustomHttpServletRequestSpanExtractor.class);

	@Override
	public Span joinTrace(HttpServletRequest carrier) {
		//String correlationID = LoggingCorrelationFilterHelper.extractCorrelationIdFromRequest(carrier);
		//long traceId = Span.hexToId(carrier.getHeader(correlationID));
	
	
		  long traceId = Span.hexToId(carrier.getHeader("correlation-id"));
		  System.out.println(carrier.getHeader("correlation-id"));
		//long traceId = Span.hexToId(carrier.getHeader(name));
		Span.SpanBuilder builder = Span.builder().traceId(traceId);
	
		return builder.build();
	}

}
