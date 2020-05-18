package microservice2.SpanExtractor;

import org.springframework.context.annotation.Bean;

//import zipkin2.Span;

/*import brave.Span;*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.sleuth.*;
/*import org.springframework.cloud.sleuth.instrument.web.HttpSpanExtractor;*/

import org.springframework.cloud.sleuth.SpanExtractor;
import org.springframework.cloud.sleuth.SpanInjector;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.SpanExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CustomHttpServletResponseSpanInjector
implements SpanInjector<HttpServletResponse> {

@Override
public void inject(Span span, HttpServletResponse carrier) {
//carrier.addHeader("correlation-id", Span.idToHex(span.getTraceId()));
//carrier.addHeader("mySpanId", Span.idToHex(span.getSpanId()));
// inject the rest of Span values to the header
}
}