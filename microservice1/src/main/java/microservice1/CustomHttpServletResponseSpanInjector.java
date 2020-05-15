/*
 * package microservice1; static class CustomHttpServletResponseSpanInjector
 * implements SpanInjector<HttpServletResponse> {
 * 
 * @Override public void inject(Span span, HttpServletResponse carrier) {
 * carrier.addHeader(Span.TRACE_ID_NAME, span.traceIdString());
 * carrier.addHeader(Span.SPAN_ID_NAME, Span.idToHex(span.getSpanId())); } }
 * 
 * static class HttpResponseInjectingTraceFilter extends GenericFilterBean {
 * 
 * private final Tracer tracer; private final SpanInjector<HttpServletResponse>
 * spanInjector;
 * 
 * public HttpResponseInjectingTraceFilter(Tracer tracer,
 * SpanInjector<HttpServletResponse> spanInjector) { this.tracer = tracer;
 * this.spanInjector = spanInjector; }
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * servletResponse, FilterChain filterChain) throws IOException,
 * ServletException { HttpServletResponse response = (HttpServletResponse)
 * servletResponse; Span currentSpan = this.tracer.getCurrentSpan();
 * this.spanInjector.inject(currentSpan, response);
 * filterChain.doFilter(request, response); } }
 */