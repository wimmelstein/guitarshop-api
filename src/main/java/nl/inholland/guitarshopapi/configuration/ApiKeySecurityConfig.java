package nl.inholland.guitarshopapi.configuration;

import lombok.extern.java.Log;
import nl.inholland.guitarshopapi.dao.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@Log
public class ApiKeySecurityConfig extends WebSecurityConfigurerAdapter {

  private ApiKeyRepository repository;

  public ApiKeySecurityConfig(ApiKeyRepository repository) {
    log.info("Security configured");
    this.repository = repository;
  }

  @Value("${guitarshop.api.token.header-name}")
  private String headerName;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    ApiKeyAuthFilter filter = new ApiKeyAuthFilter(headerName);
    filter.setAuthenticationManager(authentication -> {
      String principle = (String) authentication.getPrincipal();

      if (!repository.findById(principle).isPresent()) {
        throw new BadCredentialsException("API Key was not found in the system");
      }
      authentication.setAuthenticated(true);
      return authentication;
    });

    http
        .antMatcher("/guitars/**")
        .csrf().disable()  // disable X-site forgery
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // every new request needs authentication
        .and()
        .addFilter(filter) //  Check for the correct header value
        .authorizeRequests()
        .anyRequest()
        .authenticated();
  }
}
