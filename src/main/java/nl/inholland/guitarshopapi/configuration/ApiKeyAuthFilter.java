package nl.inholland.guitarshopapi.configuration;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

  private String headerName;

  public ApiKeyAuthFilter(String headerName) {
    this.headerName = headerName;
  }

  @Override
  protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {
    return httpServletRequest.getHeader(headerName);
  }

  @Override
  protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
    return "N/A";
  }
}
