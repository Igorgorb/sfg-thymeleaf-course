package guru.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author igorg
 * @date 16 серп. 2022 р.
 */
@Configuration
public class SpringSecConfig {//extends WebSecurityConfigurerAdapter {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withUsername("user")
      .password("{noop}user")
      .roles("USER")
      .build();
    UserDetails admin = User.withUsername("admin")
      .password("{noop}admin")
      .roles("ADMIN", "USER")
      .build();
    return new InMemoryUserDetailsManager(user, admin);
  }

  @Bean
  SecurityFilterChain web(HttpSecurity http) throws AuthenticationException, Exception {
//    http
//      .authorizeHttpRequests((authorize) -> authorize
//      .anyRequest().authenticated());
        http.authorizeRequests().antMatchers("/", "/index/**", "/product/**", "/checkout", "/docheckout").permitAll()
                .and().authorizeRequests().antMatchers("/login","logout").permitAll()
                .and().authorizeRequests().antMatchers("/static/css/**","/js/**", "/images/**", "/**/favicon.ico").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
                .and().logout()
                        .deleteCookies("remove")
                        .invalidateHttpSession(true)
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logout-success")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               ;

    return http.build();
  }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN", "USER")
//                .and().withUser("user").password("user").roles( "USER");
//}
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/", "/index/**", "/product/**", "/checkout", "/docheckout").permitAll()
//                .and().authorizeRequests().antMatchers("/login","logout").permitAll()
//                .and().authorizeRequests().antMatchers("/static/css/**","/js/**", "/images/**", "/**/favicon.ico").permitAll()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
//                .and().logout()
//                        .deleteCookies("remove")
//                        .invalidateHttpSession(true)
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/logout-success")
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//               ;
//    }
}
