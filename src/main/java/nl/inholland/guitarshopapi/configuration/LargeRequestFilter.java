package nl.inholland.guitarshopapi.configuration;

import lombok.extern.java.Log;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
@Log
@Order(2)
public class LargeRequestFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    int size = servletRequest.getContentLength();
    log.info("Request size: " + size);
    if (size > 50) {
      log.severe(String.format("Request with size %d was too large to handle", size));
      throw new ServletException(String.format("Request of size %d bytes was rejected", size));
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }
}
