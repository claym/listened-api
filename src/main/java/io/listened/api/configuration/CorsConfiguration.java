package io.listened.api.configuration;

/**
 * Created by Clay on 6/10/2015.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@Order(-1)
public class CorsConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //http.requestMatchers().antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/rest/**")
        http.requestMatchers().antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/rest/**")
                .and()
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
}