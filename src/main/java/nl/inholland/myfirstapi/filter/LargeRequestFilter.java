package nl.inholland.myfirstapi.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

@Component
@Order(1)
public class LargeRequestFilter implements Filter {

    public final Logger logger = Logger.getLogger(this.getClass().getName());

    @Value("${guitarshop.security.request.size.max}")
    private int maxSize;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Maximum request size: " + maxSize);
        logger.info(String.format("Got request with size %d", servletRequest.getContentLength()));
        int size = servletRequest.getContentLength();
        if (size > maxSize) {
            logger.severe(String.format("Request is larger than %s, and is rejected", maxSize));
            throw new ServletException("Request too large");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
