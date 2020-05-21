package nl.inholland.guitarshopapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("user")
        .password(passwordEncoder().encode("password"))
        .roles("USER")
        .and()
        .withUser("admin")
        .password(passwordEncoder().encode("password"))
        .roles("ADMIN");
    System.out.println("Configure done...");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests()
        .antMatchers(HttpMethod.GET, "/guitars/**").permitAll()
        .antMatchers(HttpMethod.POST, "/guitars/**").hasRole("ADMIN")
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login.html")
        .loginProcessingUrl("/perform_login")
        .defaultSuccessUrl("/create-guitar.html", true)
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/perform_logout")
        .deleteCookies("JSESSIONID")
        .permitAll();
    System.out.println("Authorize done...");
      }

      /*
        In order for this to work, go to https://localhost:8443/api/login
       */

 @Bean
 public PasswordEncoder passwordEncoder() {
   return new BCryptPasswordEncoder();
 }
}
