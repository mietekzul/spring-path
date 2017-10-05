package pl.raziel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAppUserDetailsService myAppUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/app/secure/**").hasAnyRole("ADMIN", "USER")
                .and().formLogin()
                .loginPage("/app/login")
                .loginProcessingUrl("/app-login")
                .usernameParameter("app_username")
                .usernameParameter("app_password")
                .defaultSuccessUrl("/app/secure/article-details")
                .and().logout()
                .logoutUrl("/app-logout")
                .logoutSuccessUrl("/app/login")
                .and().exceptionHandling()
                .accessDeniedPage("/app/error");
    }
}
