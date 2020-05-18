/*
 * package filter;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.ServletException; import javax.servlet.ServletRequest; import
 * javax.servlet.ServletResponse; import javax.servlet.annotation.WebFilter;
 * import javax.servlet.http.HttpServletResponse; import
 * javax.servlet.FilterChain; import javax.servlet.FilterConfig;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * import brave.Tracer;
 * 
 * @WebFilter() public class AddResponseHeaderFilter implements Filter {
 * 
 * @Autowired Tracer tracer;
 * 
 * public void doFilter(ServletRequest request, ServletResponse response,
 * FilterChain chain) throws IOException, ServletException { HttpServletResponse
 * httpServletResponse = (HttpServletResponse) response; //
 * httpServletResponse.setHeader("tracer-id",
 * tracer.currentSpan().context().traceIdString());
 * httpServletResponse.setHeader("correlation-id",
 * tracer.currentSpan().context().traceIdString());
 * 
 * chain.doFilter(request, response); }
 * 
 * public void init(FilterConfig filterConfig) throws ServletException {
 * 
 * }
 * 
 * 
 * public void destroy() {
 * 
 * } }
 */

/*
 * static class HttpResponseInjectingTraceFilter extends GenericFilterBean {
 * 
 * private final Tracer tracer; private final SpanInjector<HttpServletResponse>
 * spanInjector;
 * 
 * 
 * 
 * @Bean SpanInjector<HttpServletResponse>
 * customHttpServletResponseSpanInjector() { return new
 * CustomHttpServletResponseSpanInjector(); }
 * 
 * @Bean HttpResponseInjectingTraceFilter responseInjectingTraceFilter(Tracer
 * tracer) { return new HttpResponseInjectingTraceFilter(tracer,
 * customHttpServletResponseSpanInjector()); }
 * 
 * }
 */