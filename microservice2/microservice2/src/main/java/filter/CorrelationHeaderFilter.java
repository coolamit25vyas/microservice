/*
 * package filter;
 * 
 * import java.io.IOException; import java.util.UUID;
 * 
 * import javax.servlet.DispatcherType; import javax.servlet.Filter; import
 * javax.servlet.FilterChain; import javax.servlet.ServletException; import
 * javax.servlet.ServletRequest; import javax.servlet.ServletResponse; import
 * javax.servlet.http.HttpServletRequest;
 * 
 * public class CorrelationHeaderFilter implements Filter {
 * 
 * public void doFilter(ServletRequest request, ServletResponse response,
 * FilterChain chain) throws IOException, ServletException {
 * 
 * String currentCorrId =
 * httpServletRequest.getHeader(RequestCorrelation.CORRELATION_ID_HEADER); if
 * (!currentRequestIsAsyncDispatcher(httpServletRequest)) { if (currentCorrId ==
 * null) { currentCorrId = UUID.randomUUID().toString();
 * LOGGER.info("No correlationId found in Header. Generated : " +
 * currentCorrId); } else { LOGGER.info("Found correlationId in Header : " +
 * currentCorrId); }
 * 
 * RequestCorrelation.setId(currentCorrId); }
 * 
 * filterChain.doFilter(httpServletRequest, servletResponse); }
 * 
 * public void destroy() { }
 * 
 * private boolean currentRequestIsAsyncDispatcher(HttpServletRequest
 * httpServletRequest) { return
 * httpServletRequest.getDispatcherType().equals(DispatcherType.ASYNC); }
 * 
 * }
 */