package com.ellipticalcode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by crono on 1/22/2017.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("seba").password("seba").roles("ADMIN");*/

        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/admin/login")
                .defaultSuccessUrl("/")
            .and()
                .logout()
                    .logoutSuccessUrl("/admin/login?logout")
                    .deleteCookies("spring-start-remember-me")
                    .permitAll()
            .and()
                .authorizeRequests()
                    .antMatchers("/webjars/**", "/admin/login").permitAll()
                    .antMatchers("/admin/**").authenticated()
                    .antMatchers("/**").permitAll()

            .and()
                .headers()
                    .defaultsDisabled()
                    .cacheControl();

        http
                .rememberMe()
                .key("remember-me-key")
                .rememberMeParameter("remember-me")
                .rememberMeCookieName("spring-start-remember-me")
                .tokenValiditySeconds(86400);

    }
}
