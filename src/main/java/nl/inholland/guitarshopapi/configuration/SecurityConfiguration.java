package nl.inholland.guitarshopapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("user")
        .password("{noop}password") // {noop} means that password is being sent without encoding
        .roles("USER")
        .and()
        .withUser("admin")
        .password("{noop}password")
        .roles("ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/guitars/**").permitAll()
        .antMatchers(HttpMethod.POST, "/guitars/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll()
        .successForwardUrl("/api");
      }
}
